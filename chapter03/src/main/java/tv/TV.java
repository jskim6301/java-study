package tv;

public class TV {
	private int channel;
	private int volume;
	private boolean power;
	
	public TV() {
		
	}
	public TV(int channel,int volume,boolean power) {
		this.channel = channel;
		this.volume = volume;
		this.power = power;
	}
	public void power(boolean no) {
		
	}
	
	public void channel(int channel) {
		if(!power) {
			return;
		}
		if(channel<1) {
			channel = 255;
		}else if(channel > 255) {
			channel = 1;
		}
		this.channel = channel;
	}
	
	public void channel(boolean up) {
//		if(up) {
//			channel +=1;
//		}else {
//			channel -=1;
//		}
//		channel(channel);
		
		
		channel(channel + (up?1:-1));
	}
	public void volume(int volume) {
		
	}
	
	
	public void status() {
		System.out.println("TV[channel="+11+", volume="+10+", power="+power+"]");
	}
	
	
}
