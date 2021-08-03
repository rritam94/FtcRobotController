package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcontroller.external.samples.HardwarePushbot;

    @Autonomous(name = "Recruitment: Auto Drive By Time", group = "Recruitment")

    public class RecruitmentAuto extends LinearOpMode {

        /* Declare OpMode members. */
        RecruitmentHardware robot = new RecruitmentHardware();   // Use a Pushbot's hardware
        private ElapsedTime runtime = new ElapsedTime();


        static final double FORWARD_SPEED = 0.6;
        static final double TURN_SPEED = 0.5;

        @Override
        public void runOpMode() {

            /*
             * Initialize the drive system variables.
             * The init() method of the hardware class does all the work here
             */
            robot.init(hardwareMap);

            // Send telemetry message to signify robot waiting;
            telemetry.addData("Status", "Ready to run");    //
            telemetry.update();

            // Wait for the game to start (driver presses PLAY)
            waitForStart();

            // Step through each leg of the path, ensuring that the Auto mode has not been stopped along the way

            // Step 1:  Drive forward for 3 seconds
            robot.leftDrive.setPower(FORWARD_SPEED);
            robot.rightDrive.setPower(FORWARD_SPEED);
            runtime.reset();
            while (opModeIsActive() && (runtime.seconds() < 3.0)) {
                telemetry.addData("Path", "Leg 1: %2.5f S Elapsed", runtime.seconds());
                telemetry.update();
            }

            // Step 4:  Stop and close the claw.
            robot.leftDrive.setPower(0);
            robot.rightDrive.setPower(0);
//            robot.leftClaw.setPosition(1.0);
//            robot.rightClaw.setPosition(0.0);

            telemetry.addData("Path", "Complete");
            telemetry.update();
            sleep(1000);
        }
    }
