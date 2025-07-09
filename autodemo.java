package org.firstinspires.ftc.teamcode.SpaceMonkeys;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous (name = "auto red")
public class autodemo extends LinearOpMode {

    private ElapsedTime runtime = new ElapsedTime();

    hardwaredemo robot = hardwaredemo.getInstance();

    public void runOpMode(){
        robot.init(hardwareMap);
        telemetry.addData("status", "hello drivers!");
        telemetry.update();

        waitForStart();
        encoderMove(20.5, 0.7);
        turning(100, 0.4);
        encoderMove(20.5, 0.7);
    }




    public void encoderMove(double distance, double speed) {
        double wheelcircumference = 3.5 * Math.PI;
        double wheelMotor = 537.7;
        double ticks = (distance * (wheelMotor / wheelcircumference));

        robot.left.setTargetPosition((int) Math.round(ticks));
        robot.right.setTargetPosition((int) Math.round(ticks));

        robot.left.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.right.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        robot.left.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.right.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        robot.setPower(speed, speed);

        while (opModeIsActive() && (robot.left.isBusy())) {

        }
    }
        public void turning (int ticks, double speed){
            robot.setPower(0, 0);

            robot.left.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            robot.right.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

            robot.left.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            robot.right.setMode(DcMotor.RunMode.RUN_TO_POSITION);

            robot.left.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            robot.right.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        }

    }









