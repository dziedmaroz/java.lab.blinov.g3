/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package labblinovunit3;

import Vector.Vector;
import VectorExceptions.VectorDimentionException;

/**
 *
 * @author lucian
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        testVec ();


    }

    public static void testVec ()
    {
        Vector vector[] = new Vector[5];
        for (int i=0;i<5;i++)
        {
            vector[i] = new Vector(2);
        }

        vector[0].setCoodrinate(1, 0);
        vector[0].setCoodrinate(1, 1);

        vector[1].setCoodrinate(0, 0);
        vector[1].setCoodrinate(1, 1);

        vector[2].setCoodrinate(1, 0);
        vector[2].setCoodrinate(0, 1);

        vector[3].setCoodrinate(-1, 0);
        vector[3].setCoodrinate(1, 1);

        vector[4].setCoodrinate(1, 0);
        vector[4].setCoodrinate(-1, 1);

        for (int i=0;i<5;i++)
        {
            for (int j=0;j<5;j++)
            {
                try
                {

                        System.out.printf("(%-5.3f, %-5.3f) | (%-5.3f, %-5.3f) | ||(%-5.3f, %-5.3f)||=%-5.3f | ||(%-5.3f, %-5.3f)||=%-5.3f | (%-5.3f, %-5.3f)^(%-5.3f, %-5.3f) = %-5.3f\n\n", vector[i].getCoordinate(0),
                        vector[i].getCoordinate(1),vector[j].getCoordinate(0),vector[j].getCoordinate(1),vector[i].getCoordinate(0),
                        vector[i].getCoordinate(1),vector[i].norm(),vector[j].getCoordinate(0),vector[j].getCoordinate(1),vector[j].norm(),vector[i].getCoordinate(0),vector[i].getCoordinate(1),
                        vector[j].getCoordinate(0),vector[j].getCoordinate(1),vector[i].getAngle(vector[j]) );
                }
                catch (VectorDimentionException e)
                {
                    System.out.print(e.toString());
                }

            }
        }
    }

}
