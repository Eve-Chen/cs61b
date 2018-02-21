import java.lang.Math;

public class Planet {
	public double xxPos;
	public double yyPos;
	public double xxVel;
	public double yyVel;
	public double mass;
	public String imgFileName;
	public static double g=6.67 * Math.pow(10,-11);

	public Planet(double xP, double yP, double xV,
		          double yV, double m, String img){
		xxPos=xP;
		yyPos=yP;
		xxVel=xV;
		yyVel=yV;
		mass=m;
		imgFileName=img;
	}

	public Planet(Planet p){
		xxPos=p.xxPos; //x position
		yyPos=p.yyPos; //y position
		xxVel=p.xxVel; //velocity in the x direction
		yyVel=p.yyVel;
		mass=p.mass;
		imgFileName=p.imgFileName; //name of an image in the images directory
	}

	public double calcDistance(Planet p){
		double dx=p.xxPos-this.xxPos;
		double dy=p.yyPos-this.yyPos;
		return  Math.pow((Math.pow(dx,2)+Math.pow(dy,2)),0.5);
	}

	public double calcForceExertedBy(Planet p){
		double r=this.calcDistance(p);
		double f = g*this.mass*p.mass/(r*r);
		return f;
	}

	public double calcForceExertedByX(Planet p){
		double f = this.calcForceExertedBy(p);
		double dx=p.xxPos-this.xxPos;
		double r=this.calcDistance(p);
		double fx=f*dx/r;
		return fx;
	}

	public double calcForceExertedByY(Planet p){
		double f = this.calcForceExertedBy(p);
		double dy=p.yyPos-this.yyPos;
		double r=this.calcDistance(p);
		double fy=f*dy/r;
		return fy;
	}

	public double calcNetForceExertedByX(Planet[] allPlanets){
		double sumfx=0;
		for (Planet p:allPlanets) {
			if (! this.equals(p)) {
				sumfx+=this.calcForceExertedByX(p);
			}
		}
		return sumfx;
	}

	public double calcNetForceExertedByY(Planet[] allPlanets){
		double sumfy=0;
		for (Planet p:allPlanets) {
			if (! this.equals(p)) {
				sumfy+=this.calcForceExertedByY(p);
			}
		}
		return sumfy;
	}
    public void update(double dt, double fX, double fY){
	    double accX=fX/this.mass;
	    double accY=fY/this.mass;
	    this.xxVel=this.xxVel+dt*accX;
	    this.yyVel=this.yyVel+dt*accY;
	    this.xxPos=this.xxPos+this.xxVel*dt;
	    this.yyPos=this.yyPos+this.yyVel*dt;
    }


    public void draw(){
    	StdDraw.picture(xxPos,yyPos,"./images/"+imgFileName);
    }


}
