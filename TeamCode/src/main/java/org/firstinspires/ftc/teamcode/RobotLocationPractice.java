package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;

@Disabled
public class RobotLocationPractice {
    double angle;
    double x;
    double y;

    // Contructor method
    public RobotLocationPractice(double ongle, double x, double y){
        this.angle = ongle;
        this.x = x;
        this.y = y;
    }

    public double getHeading(){
//        this method normalizes the robot heading between -180 and 180;
//        this is useful for calculating turn angles, especially when crossing the 0, 360 boundary

        double angle = this.angle; //copy the angle of imu

        while(angle > 180) {
            angle -= 360; // subtract until in target range😃
        }
        while(angle <= -180) {
            angle += 360; // add until in target range
        }
        return angle; // return normalized angle
    }

    public void turnRobot(double angleChange) {
        angle += angleChange;
    }
    public void setAngle(double angle){
        this.angle = angle;
    }

    public double getAngle() {
        return this.angle;
    }

    public void changeX(double amount){
        x += amount;
    }

    public double getX() {
        return x;
    }

    public void setX(double newX) {
        this.x = newX;
    }

    public void changeY(double amount) {
        y += amount;
    }

    public double getY() {
        return y;
    }

    public void setY(double newY) {
        this.y = newY;
    }
}