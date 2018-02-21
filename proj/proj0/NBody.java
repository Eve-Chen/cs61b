public class NBody {

	public static double readRadius(String file){
		In in = new In(file);
		int numOfPlanets=in.readInt();
		double r=in.readDouble();
		return r;
	}

	public static Planet[] readPlanets(String file){
		In in = new In(file);
		int n=in.readInt();
		double r=in.readDouble();
		Planet[] allPlanets=new Planet[n];
		int i=0;
		while(i!=n){
			double xP = in.readDouble();
            double yP = in.readDouble();
            double xV = in.readDouble();
            double yV = in.readDouble();
            double m = in.readDouble();
            String img = in.readString();
            allPlanets[i] = new Planet(xP, yP, xV, yV, m, img);
            i++;				
		}
		return allPlanets;
	}

	public static void drawBackground(double radius) {
		String imageToDraw = "./images/starfield.jpg";
		StdDraw.setScale(-1*radius, radius);

		/* Clears the drawing window. */
		StdDraw.clear();

		/* Stamps three copies of advice.png in a triangular pattern. */
		StdDraw.picture(0, 0, imageToDraw);

		/* Shows the drawing to the screen, and waits 2000 milliseconds. */
		}		

	public static void main(String[] args){
		double t = Double.parseDouble(args[0]);
		double dt = Double.parseDouble(args[1]);
		String filename=args[2];

		Planet[] allPlanets=readPlanets(filename);
		System.out.println(allPlanets[2].imgFileName);
		double radius=readRadius(filename);
		// drawBackground(radius);
		// for (Planet p:allPlanets) {
		// 	p.draw();
		// }
		// StdDraw.clear();


		for (int time=0;time<t;time+=dt){
			double[] xForces=new double[allPlanets.length];
			double[] yForces=new double[allPlanets.length];


			for (int i=0;i<allPlanets.length;i++){
				xForces[i]=allPlanets[i].calcNetForceExertedByX(allPlanets);
				yForces[i]=allPlanets[i].calcNetForceExertedByY(allPlanets);
			}
			for (int i=0;i<allPlanets.length;i++){
				allPlanets[i].update(dt,xForces[i],yForces[i]);
			}

			StdDraw.setScale(-1*radius, radius);
			StdDraw.clear();
			StdDraw.picture(0,0,"./images/starfield.jpg");
            for (Planet p:allPlanets) {
                p.draw();
            }
			StdDraw.show(10);
		}
	}
}
