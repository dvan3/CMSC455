public class hw3_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double totalArea;
		
		totalArea = area(0.1);
		System.out.println("Area with precision 0.1: " + totalArea);
		
		totalArea = area(0.01);
		System.out.println("Area with precision 0.01: " + totalArea);
		
		totalArea = area(0.001);
		System.out.println("Area with precision 0.001: " + totalArea);
		
		totalArea = area(0.0001);
		System.out.println("Area with precision 0.0001: " + totalArea);
	}
	
	public static double area(double precision)
	{
		double area = 0.0;
		
		for(double x = -3.0; x <= 3; x += precision)
		{
			for(double y = -3.0; y <= 4; y += precision)
			{
				double circle1 = Math.pow((x - 2), 2) + Math.pow((y - 2), 2);
				double circle2 = Math.pow(x, 2) + Math.pow((y - 2), 2);
				double circle3 = Math.pow(x, 2) + Math.pow(y, 2);
				
				if(circle1 > 1)
				{
					if(circle2 <= 4)
					{
						if(circle3 <= 9)
						{
							area += Math.pow(precision, 2);
						}
					}
				}
			}
		}
		return area;
	}
}
