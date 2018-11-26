import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public final class FirstInFirstOutAlgorithmTest {
	


	@Test
	public void WBA_01() {
		List<ICar> lstCars = new ArrayList<>();
		FirstInFirstOutAlgorithm fifo = new FirstInFirstOutAlgorithm();
		Direction d = Direction.UP;
		int floorNumber = 5;
		ICar bestCar = fifo.findBestCar(lstCars, d, floorNumber);
		assertEquals(bestCar, null);
		
	}
	
	@Test
	public void WBA_02() {
		Car car1 = new Car();
		List<ICar> lstCars = new ArrayList<>();
		lstCars.add(car1);
		FirstInFirstOutAlgorithm fifo = new FirstInFirstOutAlgorithm();
		Direction d = Direction.UP;
		int floorNumber = 5;
		ICar bestCar = fifo.findBestCar(lstCars, d, floorNumber);
		assertEquals(car1, bestCar);
		
	}
	
	@Test
	public void WBA_03() {
		Car car1 = new Car();
		Car car2 = new Car();
		car1.setCurrentFloorNumber(4);
		car1.setStatus(CarStatus.MOVING_UP);
		List<ICar> lstCars = new ArrayList<>();
		lstCars.add(car1);
		lstCars.add(car2);
		FirstInFirstOutAlgorithm fifo = new FirstInFirstOutAlgorithm();
		Direction d = Direction.UP;
		int floorNumber = 5;
		ICar bestCar = fifo.findBestCar(lstCars, d, floorNumber);
		assertEquals(car1, bestCar);
		
	}
	
	@Test
	public void WBA_04() {
		Car car1 = new Car();
		Car car2 = new Car();
		car1.setCurrentFloorNumber(6);
		car1.setStatus(CarStatus.MOVING_DOWN);
		List<ICar> lstCars = new ArrayList<>();
		lstCars.add(car1);
		lstCars.add(car2);
		FirstInFirstOutAlgorithm fifo = new FirstInFirstOutAlgorithm();
		Direction d = Direction.DOWN;
		int floorNumber = 5;
		ICar bestCar = fifo.findBestCar(lstCars, d, floorNumber);
		assertEquals(car1, bestCar);
		
	}

}
