/**
 * File:    homework1
 * Homework 1
 * Author:  Dave Van
 * Date:    5/29/13
 * E-mail:  dvan3@umbc.edu
 */

/**
 * @author Dave
 *
 */
public class rocket {
	/**
	 * @param args
	 */
	@SuppressWarnings("unused")
	public static void main(String[] args) 
	{
		//gravity meters per second
		final double gravity = 9.80665;
		//density of air
		final double airDensity = 1.293;
		//change in time
		final double dt = 0.1; 
		
		//in meters
		double length = 0.311;
		double diameter = 0.0241;
		//square meters
		double bodyArea = 0.000506;
		double finsArea = 0.00496;
		//dimension less drag
		double dragBody = 0.45;
		double dragFins = 0.01;
		//kilograms
		double mass = 0.0340;
		double initialEngine = 0.0242;
		double finalEngine = 0.0094;
		
		//thrust at times
		double[] thrust = new double[] {0.0, 6.0, 12.5, 5.0, 4.5, 4.5, 4.5, 4.5,
									4.5, 4.5, 4.5, 4.5, 4.5, 4.5, 4.5, 4.5,
									4.5, 4.5, 4.5, 0.0};
		
		double t = 0.0; //time
		double s = 0.0; //height
		double v = 0.0; //velocity
		double a = 0.0; //acceleration
		double F = 0.0; //total force
		double m = mass + initialEngine; //mass
		double vp = 0.0; //previous velocity
		double sp = 0.0; //previous height
		
		double FdBody; //force of drag on body
		double FdFins; //force of drag on fins
		double Fg; //force of gravity toward center of Earth
		double Ft; //value from thrust curve at this time
		double dv; //velocity change
		double ds; //distance in meters moved in time dt
		
		int index;
	
		System.out.println("**************START ROCKET**************");	
		while(v > -0.1)
		{
			System.out.println("**************TIME ADVANCING**************");
			//time advancing
			t = t + dt; 
			System.out.println("Time: " + t + "s");
			
			//Fd = Cd * Rho * A * v^2 / 2
			FdBody = dragBody * airDensity * bodyArea * Math.pow(v, 2) / 2;
			System.out.println("Force of Body Drag: " + FdBody + "N");
			
			FdFins = dragFins * airDensity * finsArea * Math.pow(v, 2) / 2;
			System.out.println("Force of Fins Drag: " + FdFins + "N");
			
			//Fg = m * g
			Fg = m * gravity;
			System.out.println("Force of Gravity: " + Fg + "N");
			
			//Ft = thrust
			index = (int)(t * 10);
			if(index < thrust.length)
			{
				Ft = thrust[index];
			}
			else
			{
				Ft = 0.0;
			}
			System.out.println("Thrust during time: " + Ft + "N");
			
			//F = Ft - (Fd body + Fd fins + Fg)
			F = Ft - (FdBody + FdFins + Fg);
			System.out.println("Force: " + F + "N");
			
			//a = F / m
			a = F / m;
			System.out.println("Acceleration: " + a + "m/s^2");
			
			//dv = a * dt
			dv = a * t;
			System.out.println("Change in Velocity: " + dv + "m/s");
			
			//v = vp + dv
			v = vp + dv;
			vp = v; //previous velocity
			System.out.println("New Velocity: " + v + "m/s");
			
			//ds = v * dt
			ds = v * t;
			System.out.println("Change in Distance: " + ds + "m");
			
			//s = sp + ds
			s = sp + ds;
			sp = s; //previous height
			System.out.println("New Distance: " + s + "m");
			
			//m = m - 0.0001644 * Ft
			m = m - 0.0001644 * Ft;
			System.out.println("New Mass: " + m + "kg");
		}

	}
}
