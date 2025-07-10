package org.firstinspires.ftc.teamcode.SpaceMonkeys;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp (name = "encoder tester")
public class encodertester extends LinearOpMode {
    hardwaredemo robot = hardwaredemo.getInstance();

    public void runOpMode() {
        robot.init(hardwareMap);

        telemetry.addData("staus", "hello driver");
        telemetry.update();

        boolean pressingx = false;
        int flipperposition = 0;
        boolean pressinga = false;
        boolean pressingb = false;
        int armposition = 0;
        boolean pressingy = false;



        waitForStart();
        while (opModeIsActive()) {

            robot.arm.setTargetPosition(armposition);
            robot.arm.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            robot.arm.setPower(1);

            if (gamepad1.x && !pressingx) {
                armposition += 10;
                pressingx = true;

            } else if (!gamepad1.x) {
                pressingx = false;

            }
            if (gamepad1.y && !pressingy) {
                armposition -= 10;
                pressingy = true;

            } else if (!gamepad1.y) {
                pressingy = false;

            }

            robot.flipper.setTargetPosition(flipperposition);
            robot.flipper.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            robot.flipper.setPower(1);

            if (gamepad1.a && !pressinga) {
                flipperposition += 10;
                pressinga = true;

            } else if (!gamepad1.a) {
                pressinga = false;

            }
            if (gamepad1.b && !  pressingb) {
                flipperposition -= 10;
                pressingb = true;

            } else if (!gamepad1.b) {
                pressingb = false;}

            telemetry.addData("arm postion", armposition);
            telemetry.addData("flipper postion", flipperposition);
            telemetry.update();
        }

    }
}