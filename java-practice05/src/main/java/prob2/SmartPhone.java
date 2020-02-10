package prob2;

public class SmartPhone extends MusicPhone {
	
	public SmartPhone() {
	}
	@Override
	public void execute( String function ) {
		if ( function.equals("앱") ) {
			playApp();
			return;
		}else if(function.equals("음악")) {
			download();
			return;
		}
		
		super.execute( function );
	}
	private void playApp() {
		System.out.println("앱실행");
	}
	private void download() {
		System.out.println("다운로드해서 음악재생");
	}
}
