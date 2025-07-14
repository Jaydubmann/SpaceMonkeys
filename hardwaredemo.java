package org.firstinspires.ftc.teamcode.SpaceMonkeys;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.Range;


public class hardwaredemo {

    public DcMotor right;

    public DcMotor left;

    public Servo clawServo;

    public Servo clawServoright;

    public Servo rampServo;

    public DcMotor flipper;

    public DcMotor arm;


    public double maxSpeed = 1;
    private static hardwaredemo myInstance = null;
    public static hardwaredemo getInstance() {


        if (myInstance == null) {
            myInstance = new hardwaredemo();
        }
            return myInstance;
   }
            public void init(HardwareMap hwmap) {
                right = hwmap.get(DcMotor.class, "right");
                right.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
                right.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
                right.setPower(0);

                left = hwmap.get(DcMotor.class, "left");
                left.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
                left.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
                left.setDirection(DcMotor.Direction.REVERSE);
                left.setPower(0);

                flipper = hwmap.get(DcMotor.class, "flipper");
                flipper.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
                flipper.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);


                arm = hwmap.get(DcMotor.class, "arm");
                arm.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
                arm.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

                //intialize servo
                clawServo = hwmap.get(Servo.class, "claw servo");
                clawServoright = hwmap.get(Servo.class, "right servo");
                rampServo = hwmap.get(Servo.class, "ramp servo");
            }
        public void setPower(double motor1, double motor2) {
            right.setPower(Range.clip(motor1, -maxSpeed, maxSpeed));
            left.setPower(Range.clip(motor2, -maxSpeed, maxSpeed));
                }

            }


