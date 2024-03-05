package ie.tudublin;

import ddf.minim.AudioBuffer;
import ddf.minim.AudioInput;
import ddf.minim.AudioPlayer;
import ddf.minim.Minim;
import processing.core.PApplet;

import java.util.Random;

public class Audio1 extends PApplet
{
    Minim minim;
    AudioPlayer ap;
    AudioInput ai;
    AudioBuffer ab;

    int mode = 0;

    float[] lerpedBuffer;
    float y = 0;
    float smoothedY = 0;
    float smoothedAmplitude = 0;

    public void settings()
    {
        //size(1024, 1000, P3D);
        size(800,800);
    }

    public void setup()
    {
        minim = new Minim(this);
        // Uncomment this to use the microphone
        // ai = minim.getLineIn(Minim.MONO, width, 44100, 16);
        // ab = ai.mix; 
        ap = minim.loadFile("heroplanet.mp3", 1024);
        ap.play();
        ab = ap.mix;
        colorMode(HSB);

        y = height / 2;
        smoothedY = y;

        lerpedBuffer = new float[width];

        Random random = new Random() ;
    }   

    public void draw()
    {
        background(0);
        float average = 0;
        float sum = 0;


        for(int i = 0 ; i < ab.size() ; i ++)
        {
            sum += abs(ab.get(i));
            lerpedBuffer[i] = lerp(lerpedBuffer[i], ab.get(i), 0.05f);
        }
        average= sum / (float) ab.size();

        smoothedAmplitude = lerp(smoothedAmplitude, average, 0.1f);

    }
    
    public void Droplet(int numOfDroplets){
        

        int x = random.nextInt(800);
        int y = random.nextInt(800);
        int r = random.nextInt(8);

        int count = r;

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < i; j++) {
                for (int k = 0; k < numOfDroplets; k++) {

                    if (checkDistance(k)) {
                        drawOver(x, y, r);
                    }else{

                    }
                }
            }
        }


    }

    public drawCircles(int numOfDroplets){
        for (int i = 0; i < numOfDroplets; i++) {
                circle(arrayX[i], arrayY[i], arrayR[i]);
        }
    }
}
