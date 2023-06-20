package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.PwmControl;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.ServoImplEx;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;

@TeleOp(name="FirstTeleOp", group ="Linear OpMode")
public class FirstTeleOp extends LinearOpMode {
    private ElapsedTime runtime = new ElapsedTime();
    private DcMotor leftFront;
    private DcMotor leftBack;
    private DcMotor rightFront;
    private DcMotor rightBack;
    private DcMotor leftMotor;
    private DcMotor rightMotor;
    private Servo claw;


    @Override
    public void runOpMode(){

        leftFront = hardwareMap.get(DcMotor.class, "lf");
        leftBack = hardwareMap.get(DcMotor.class, "lb");
        rightFront = hardwareMap.get(DcMotor.class, "rf");
        rightBack = hardwareMap.get(DcMotor.class, "rb");
        leftMotor = hardwareMap.get(DcMotor.class, "leftLift");
        rightMotor = hardwareMap.get(DcMotor.class, "rightLift");
        claw = hardwareMap.get(Servo.class, "clawServo");


        waitForStart();
        runtime.reset();



        while(opModeIsActive()){
            double lfPower;
            double lbPower;
            double rfPower;
            double rbPower;

            double servoPositionClose = 0.3;
            double servoPositionOpen = 0.745;

            claw.setPosition(servoPositionClose);


            double y = -gamepad1.left_stick_y;
            double x = -gamepad1.left_stick_x;
            boolean liftUp = gamepad1.dpad_up;
            boolean liftDown = gamepad1.dpad_down;
            boolean closeButton = gamepad1.a;
            boolean openButton = gamepad1.b;

            if (closeButton){
                claw.setPosition(servoPositionClose);

            }

            if (openButton){
                claw.setPosition(servoPositionOpen);
            }


            lfPower = Range.clip(-(y-x), -1.0, 1.0);
            lbPower = Range.clip(-(y-x), -1.0, 1.0);
            rfPower = Range.clip(y+x, -1.0, 1.0);
            rbPower = Range.clip(y+x, -1.0, 1.0);

            leftFront.setPower(lfPower);
            leftBack.setPower(lbPower);
            rightFront.setPower(rfPower);
            rightBack.setPower(rbPower);

            





            //rightIntake, rightLift, leftIntake, leftLift


        }
    }
}
