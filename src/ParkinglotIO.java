/**
 * This class contains basic input and output method for parkingLot.
 * The data of parkingLot is saved in a txt file named Database.
 *
 * @author Group 44
 * @version 2.0
 */

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ParkinglotIO {
	//public static ParkingLot QM = new ParkingLot(8, 8, 8);
	//public static ParkingLot QM1 = new ParkingLot(); //用于传递qm 操作时对qm1操作

    public void parkingLotOutput(ParkingLot QM) {
        //ParkingLot QM1=new ParkingLot(8,8,8); //该行用于重置
        //QM1.setBikeOnTheWay(0);
        //QM1.takeBikeFromA();
        //QM1.returnBikeToB();
        //QM1.getBikeOnTheWay();
        //QM = QM1;

        try {
            FileOutputStream fos = new FileOutputStream(new File("src/Database"));
            ObjectOutputStream oos;
            oos = new ObjectOutputStream(fos);
            oos.writeObject(QM);
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ParkingLot parkingLotInput() throws IOException, ClassNotFoundException {
    		ParkingLot QM=new ParkingLot();
        try {
            File file = new File("src/Database");
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream iis = new ObjectInputStream(fis);

            QM = (ParkingLot) iis.readObject();
            iis.close();
            //System.out.println(QM.getBikeInA());
            //System.out.println(QM.getBikeInB());
            //System.out.println(QM.getBikeOnTheWay());
        } catch (IOException|ClassNotFoundException e) {
            e.printStackTrace();
        }
        return QM;
    }


}
