/* get_mpf_pi.c  pi = 24*atan(b2)  b1=2-sqrt(3)  b2=(2*sqrt(b1)-1)/b1 */
/*              based on 4*atan(1) = pi               */
/*              based on tan(a/2) = (1-cos(a))/sin(a) */
/*              further reduction for tan(a/4)        */
/*              sin(a/2)=sqrt((1-cos(a))/2)           */
/*              cos(a/2)=sqrt((1+cos(a))/2)           */
/* atan(1/x)=Pi/2-atan(x)   atan(-x)=-atan(x)         */

#include <stdio.h>
#include <stdlib.h>
#include "gmp.h"

int main(int argc, char *argv[])
{
   mpf_t b1, b2, pi, sum, cnt, xx, tmp;
   mpf_t mp1, mp2, mp3;
   int digits=50;
   mpf_t rfact[50]; /* reciprocal factorial */
   int i, sub;

   /* mpf initialization */
   mpf_set_default_prec(digits*3.32);
   mpf_init_set_si(mp1,1);
   mpf_init_set_si(mp2,2);
   mpf_init_set_si(mp3,3);
   mpf_init(b1);
   mpf_init(b2);
   mpf_init(pi);
   mpf_init_set_si(sum,0); /* atan series */
   mpf_init(cnt);
   mpf_init(xx);
   mpf_init(tmp);

   printf("get_mpf_pi.c using digits=%d \n",digits); 
   mpf_sqrt(b1,mp3);
   mpf_sub(b1,mp2,b1); /* b1 = 2.0-sqrt(3.0); */
   gmp_printf("b1= %55.50Ff \n", b1);
   mpf_sqrt(b2,b1);
   mpf_mul(b2,mp2,b2);
   mpf_sub(b2,b2,mp1);
   mpf_div(b2,b2,b1); /* b2 = (2.0*sqrt(b1)-1)/b1; */
   gmp_printf("b2= %55.50Ff \n", b2);

   /* atan(x) = x - x^3/3 + x*5/5 - x^7/7 + x^9/9 ... +x^49/49  x=b2*/
   mpf_mul(xx,b2,b2);
   mpf_set_si(cnt,49);
   mpf_div(sum,mp1,cnt);
   sub=1;
   for(i=47; i>1; i=i-2)
   {
      mpf_mul(sum,sum,xx);
      mpf_set_si(cnt,i);
      mpf_div(tmp,mp1,cnt);
      if(sub) mpf_sub(sum,sum,tmp);
      else    mpf_add(sum,sum,tmp);
      sub=1-sub;
   }
   mpf_mul(sum,sum,xx);
   mpf_add(sum,sum,mp1);
   mpf_mul(sum,sum,b2);
   mpf_mul_ui(pi,sum,24);
   gmp_printf("mpf_pi=%52.49Ff \n", pi);
   printf    ("    Pi= 3.1415926535897932384626433832795028841971 \n");
   return 0;
} /* end get_mpf_pi.c */
