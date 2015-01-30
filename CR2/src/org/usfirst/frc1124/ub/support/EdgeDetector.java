package org.usfirst.frc1124.ub.support;

public class EdgeDetector {
	private boolean risingEdge;
	private boolean fallingEdge;
	private boolean state;
	
	public int step(boolean s) {
		if(state != s) {
			if(s) {
				risingEdge = true;
				return 1;
			} else {
				fallingEdge = true;
				return -1;
			}
		}
		risingEdge = false;
		fallingEdge = false;
		return 0;
	}
	public boolean rising() {
		return risingEdge;
	}
	public boolean falling() {
		return fallingEdge;
	}
	public int edge() {
		if(risingEdge) {
			return 1;
		} else if(fallingEdge) {
			return -1;
		} else {
			return 0;
		}
	}
	
	public EdgeDetector() {
		risingEdge = false;
		fallingEdge = false;
		state = false;
	}
	public EdgeDetector(boolean init) {
		risingEdge = false;
		fallingEdge = false;
		state = init;
	}
}
