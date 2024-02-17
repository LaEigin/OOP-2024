package ie.tudublin;

import processing.core.PApplet;



public class Arrays extends PApplet
{
	String[] months = {"JAN", "FEB", "MAR", "APR", "MAY", "JUN", "JUL", "AUG", "SEP", "OCT", "NOV", "DEC"};

	float[] rainfall = {40, 120, 86, 224, 200, 174, 112, 80, 124, 222, 200, 80};

	int mode = 0;

	int special_num = 700/12;

	public float map1(float a, float b, float c, float d, float e)
	{
		float r1 = c -b;
		float r2 = e - d;

		float howFar = a - b;
		return d + (howFar / r1) * r2;
	}

	void randomize()
	{
		for (int i = 0; i < rainfall.length; i++) {
			rainfall[i] = random(500);
		}
	}

	public void keyPressed() {
		if (key >= '0' && key <= '9') {
			mode = key - '0';
		}
		println(mode);
	}

	public void settings()
	{
		size(800, 800);

		String[] m1 = months;
		print(m1[0]);
		for(int i = 0; i < months.length; i ++)
		{
			println("Month: " + months[i] + "\t" + rainfall[i]);
		}
		for (String s : m1) {
			println(s);
		}

		int minIndex = 0;
		for(int i= 0 ; i < rainfall.length ; i ++)
		{
			if (rainfall[i] < rainfall[minIndex])
			{
				minIndex = i;
			}
		}
		
		int maxIndex = 0;
		for(int i= 0 ; i < rainfall.length ; i ++)
		{
			if (rainfall[i] > rainfall[maxIndex])
			{
				maxIndex = i;
			}
		}

		println("The month with the minimum rainfall was " + months[minIndex] + " with " + rainfall[minIndex] + "rain");
		println("The month with the max rainfall was " + months[maxIndex] + " with " + rainfall[maxIndex] + "rain");
		
		
		float tot = 0;
		for(float f:rainfall)
		{
			tot += f;
		}

		float avg = tot / (float) rainfall.length;

		// a b-c d-e;
		println(map1(5, 0, 10, 0, 100));
		// 50

		println(map1(25, 20, 30, 200, 300));
		// 250

		println(map1(26, 25, 35, 0, 100));
		// 10 


	}

	public void setup() {
		colorMode(RGB);
		background(255,255,255);
		randomize();
		
		
	}

	
	public void draw()
	{	
		switch (mode) {
			case 0:
				background(0);
				float w = width / (float)months.length - 5;
				for(int i = 0 ; i < months.length ;  i ++)
				{
					fill(255, 255, 255);
					stroke(255,255,255);
		
					text(months[i], 65+60*i, height-10);
					line(50, height-50, 50, 50);
					text(10*i, 25, height - (i*(58) + 56));
					line(45, height - (i*(58) - 58) , 50, height - (i*(58) - 58));
				}


				for (int i = 0; i < months.length; i++) {
					fill(25*i, 25*i, 25*i);
					rect(50+60*i, height-50, w, -rainfall[i]);
				}
				
				break;
			case 1: 
				background(0);
				fill(255, 255, 255);
				line(50, 50, 50, height - 50);
				line(50, height - 50, width - 50, height - 50);
				for (int i = 0; i < months.length; i++) {
					text(months[i], (70+ (special_num * i)), height - 25);
				}

				for (int i = 0; i < months.length + 1; i++) {
					text((i * 10), 25 , (height - (i * special_num) - 50));
					line(45, (height - (i * special_num) - 50) , 50, (height - (i * special_num) - 50));
				}

				line(50,( height - (50 + rainfall[0])), (special_num)  + (special_num/2),  (height - (50 + rainfall[1])));

				for (int i = 1; i < months.length - 1; i++) {
					line((special_num * i) + (special_num/2),( height - (50 + rainfall[i])), (special_num * (i + 1))  + (special_num/2),  (height - (50 + rainfall[i+1])));
				}
				
				break;
			case 2:
				break;
		}

	}
}