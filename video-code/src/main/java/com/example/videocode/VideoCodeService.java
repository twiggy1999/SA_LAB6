package com.example.videocode;

import java.io.InputStream;
import java.io.InputStreamReader;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;

public class VideoCodeService extends Thread {

    Message message;
    Channel channel;
    String handBrakeExe = "C:\\Users\\t-zhangl\\Downloads\\HandBrakeCLI-1.3.3-win-x86_64\\HandBrakeCLI";
    String[] choices = { "360", "720", "1080" };
    String[] backgrounds = { " -X 480 -Y 360", " -X 1280 -Y 720", " -X 1920 -Y 1080" };
    VideoCodeService(Message msg, Channel cnl) {
        this.message = msg;
        this.channel = cnl;
    }
    public void run() {
        try {
            for (int i = 0; i < 3; ++i) {
                String body=new String(message.getBody());
                String istring = " -i " + "C:\\SA_Lab6\\video-sample\\raw\\" + body;
                String ostring = " -o " + "C:\\SA_Lab6\\video-sample\\" + choices[i] + "\\" + body;
        String command = handBrakeExe + istring + ostring + backgrounds[i];
        String[] commandWord = command.split(" ");
             ProcessBuilder processBuilder = new ProcessBuilder();
             processBuilder.command(commandWord);
             processBuilder.redirectErrorStream(true);
             Process process = processBuilder.start();
                InputStream inputStream = process.getInputStream();
                InputStreamReader inputStreamreader = new InputStreamReader(inputStream, "gbk");
            char[] s = new char[1024];
            int length = -1;
                while ((length = inputStreamreader.read(s)) != -1) {
                 String temp = new String(s, 0, length);
                 if (temp.compareTo("HandBrake has exited.") == 0) {
                    process.destroy();
                    break;
                }
                }
                process.waitFor();
                istring.close();
                inputStreamreader.close();
            }
            channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
