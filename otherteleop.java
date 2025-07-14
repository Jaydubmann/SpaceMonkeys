package org.firstinspires.ftc.teamcode.SpaceMonkeys;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.Range;

@TeleOp(name = "otherteleop")
public class otherteleop extends LinearOpMode {
    hardwaredemo robot = hardwaredemo.getInstance();

    public void runOpMode() {
        robot.init(hardwareMap);



        telemetry.addData("staus", "hello driver");
        telemetry.update();
        boolean pressingrb = false;
        boolean claw = false;
        boolean pressingrb1 = false;
        boolean ramp = false;




        waitForStart();
        while (opModeIsActive()) {

            robot.flipper.setPower(gamepad2.left_stick_y);
            robot.arm.setPower(Range.clip(-gamepad2.right_stick_y,-0.5,0.5));

            double movement = -gamepad1.left_stick_y;
            double turning = gamepad1.right_stick_x;

            double left = movement + turning;
            double right = movement - turning;

            double max = Math.max(Math.abs(left), Math.abs(right));
            if (max > 1.0) {
                left /= max;
                right /= max;
            }
            robot.left.setPower(left);
            robot.right.setPower(right);

            if (gamepad2.right_bumper && !pressingrb) {
              if (claw) {
                  robot.clawServo.setPosition(0.100);
                  robot.clawServoright.setPosition(0.308);
                    claw = false;
                } else {
                  robot.clawServo.setPosition(0.325);
                  robot.clawServoright.setPosition(0.097);
                  claw = true;

              }
                pressingrb = true;
            } else if (!gamepad2.right_bumper) {
                pressingrb = false;

            }
            if (gamepad1.right_bumper && !pressingrb1) {
                if (ramp) {
                    robot.rampServo.setPosition(0.184);
                    ramp = false;
                } else {
                    robot.rampServo.setPosition(0.785);
                    ramp = true;

                }
                pressingrb1 = true;
            } else if (!gamepad1.right_bumper) {
                pressingrb1 = false;

            }

        }
    }
}
