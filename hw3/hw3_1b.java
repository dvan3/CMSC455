public class hw3_1b
{
  public hw3_1b()
  {
    double area;
    double a = 0.0;
    double b = 1.0;
    int n = 8;
    double x[] = new double[n+1];
    double w[] = new double[n+1];

    new gaulegf(a, b, x, w, n);
    area = 0.0;
    for(int i=1; i<=n; i++)
    {
      area += w[i]*f(x[i]);
    }
    System.out.println("Number of points: " + n);
    System.out.println("computed area: " + area);
    System.out.println("error: "+Math.abs((area - (1.0 - Math.cos(1.0)))));

    n = 16;
    x = new double[n+1];
    w = new double[n+1];

    new gaulegf(a, b, x, w, n);
    area = 0.0;
    for(int i=1; i<=n; i++)
    {
	area += w[i]*f(x[i]);
    }
    System.out.println("Number of points: " + n);
    System.out.println("computed area: " + area);
    System.out.println("error: "+Math.abs((area - (1.0 - Math.cos(1.0)))));

  }

  double f(double p) // function to integrate
  {
      return Math.sin(p);
  }

  public static void main (String[] args)
  {
    new hw3_1b();
  }
}