package tirepressuremonitoringsystem;

public class Alarm {
	private final double lowPressureThreshold = 17;
	private final double highPressureThreshold = 21;
	private Sensor sensor = new Sensor();
	private boolean alarmOn = false;
	
	public Alarm(Sensor sensor2) {
		 this.sensor = sensor2;
	}
	public void check() {
		double psiPressureValue = sensor.popNextPressurePsiValue();
		if (psiPressureValue < lowPressureThreshold || highPressureThreshold < psiPressureValue) {
			alarmOn = true;
		}
	}

	public boolean isAlarmOn() {
		return alarmOn;
	}
}

