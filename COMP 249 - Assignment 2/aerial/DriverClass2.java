package aerial;
import planes.Airplane;
import copters.Helicopter;
import copters.Quadcopter;
import advanced_copters.Multirotor;
import unmanned.UAV;
import advanced_unmanned.AgriculturalDrone;
import advanced_unmanned.MAV;

class DriverClass2 {
	
	public static FlyingObjects[] copyFlyingObjects(FlyingObjects[] array) {
		
		FlyingObjects[] array2 = new FlyingObjects[array.length];
		for(int i = 0; i < array2.length; i++) {
			array2[i] = new FlyingObjects(array[i]);
		}
		
		return array2;
	}
	
	public static void main(String[] args) {

		FlyingObjects[] array = new FlyingObjects[21];
			
		Airplane a1 = new Airplane("Bombadier", 500000, 2000);
		Helicopter h1 = new Helicopter("Falcon", 450000, 1200, 12, 2016, 12);
		Quadcopter q1 = new Quadcopter("Falcon", 500000, 1300, 12, 2014, 12, 120);
		Multirotor m1 = new Multirotor("Hawk", 400000, 1100, 8, 2018, 12, 6);
		UAV u1 = new UAV(25, 3000);
		AgriculturalDrone ad1 = new AgriculturalDrone(40, 4250, "Bee", 20);
		MAV md1 = new MAV(10, 1300, "UX101", 6);
		
		Airplane a2 = new Airplane("Bombadier", 550000, 2000);
		Helicopter h2 = new Helicopter("Falcon", 350000, 1200, 12, 2016, 12);
		Quadcopter q2 = new Quadcopter("Falcon", 550000, 1300, 12, 2014, 12, 120);
		Multirotor m2 = new Multirotor("Hawk", 425000, 1100, 8, 2018, 12, 6);
		UAV u2 = new UAV(25, 3000);
		AgriculturalDrone ad2 = new AgriculturalDrone(40, 4500, "Bee", 20);
		MAV md2 = new MAV(10, 1250, "UX101", 6);
		
		Airplane a3 = new Airplane("Bombadier", 600000, 2000);
		Helicopter h3 = new Helicopter("Falcon", 375000, 1200, 12, 2016, 12);
		Quadcopter q3 = new Quadcopter("Falcon", 600000, 1300, 12, 2014, 12, 120);
		Multirotor m3 = new Multirotor("Hawk", 500000, 1100, 8, 2018, 12, 6);
		UAV u3 = new UAV(25, 3000);
		AgriculturalDrone ad3 = new AgriculturalDrone(40, 4000, "Bee", 20);
		MAV md3 = new MAV(10, 1200, "UX101", 6);
		
		array[0] = a1;
		array[1] = h1;
		array[2] = q1;
		array[3] = m1;
		array[4] = u1;
		array[5] = ad1;
		array[6] = md1;
		array[7] = a2;
		array[8] = h2;
		array[9] = q2;
		array[10] = m2;
		array[11] = u2;
		array[12] = ad2;
		array[13] = md2;
		array[14] = a3;
		array[15] = h3;
		array[16] = q3;
		array[17] = m3;
		array[18] = u3;
		array[19] = ad3;
		array[20] = md3;
		
		FlyingObjects[] array2 = copyFlyingObjects(array);
		
		for(int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
			System.out.println(array2[i]+"\n");
		}
	}

}
