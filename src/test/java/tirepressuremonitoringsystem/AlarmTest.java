package tirepressuremonitoringsystem;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AlarmTest 
{
    
    @Test
    public void Alarm_pression_basse()
    {
    	Sensor sensor = mockSensorWithPressureValue(0.0);
    	
    	Alarm alarm = new Alarm(sensor);
    	alarm.check();
        assertTrue( alarm.isAlarmOn() );
    }

	
    
    @Test
    public void Alarm_pression_forte()
    {
    	Sensor sensor = mockSensorWithPressureValue(30.0);
    	Alarm alarm = new Alarm(sensor);
    	alarm.check();
        assertTrue(alarm.isAlarmOn()); 
    }
    
    @Test
    public void Alarm_pression_seuil_securite()
    {
    	Sensor sensor = mockSensorWithPressureValue(20.0);
    	Alarm alarm = new Alarm(sensor);
    	alarm.check();
        assertFalse(alarm.isAlarmOn());
        
    }
    @Test
    public void Alarm_constante()
    {
    	Sensor sensor = mockSensorWithTwoPressureValue(0.0, 20.0);
    	Alarm alarm = new Alarm(sensor);
    	
    	alarm.check();
        assertTrue(alarm.isAlarmOn());
        
        alarm.check();
        assertTrue(alarm.isAlarmOn());
    }



	private Sensor mockSensorWithTwoPressureValue(double value1, double value2) {
		Sensor sensor = mock(Sensor.class);
    	when(sensor.popNextPressurePsiValue()).thenReturn(value1).thenReturn(value2);
		return sensor;
	}
    
    
    private Sensor mockSensorWithPressureValue(double value) {
		Sensor sensor = mock(Sensor.class);
    	when(sensor.popNextPressurePsiValue()).thenReturn(value);
		return sensor;
	}
}
