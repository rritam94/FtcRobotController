package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
@Autonomous
public class sampleOpMode extends LinearOpMode {
    DcMotor leftMotor, rightMotor;
    HardwareMap hwMap;

    @Override
    public void runOpMode() throws InterruptedException {
        hwMap = new HardwareMap(hardwareMap.appContext);
        leftMotor = hwMap.get(DcMotor.class, "leftMotor");
        rightMotor = hwMap.get(DcMotor.class, "rightMotor");

        waitForStart();
        rightMotor.setPower(1.0);
        leftMotor.setPower(1.0);
        sleep(2000);
    }
}
