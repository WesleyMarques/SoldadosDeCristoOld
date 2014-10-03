

package org.sc.views;
import javax.swing.JPanel;

public abstract class SwitchablePanel extends JPanel {

	private Window mainFrame;

	public SwitchablePanel(Window mainFrame, boolean isOpaque) {
		this.mainFrame = mainFrame;
		this.setOpaque(isOpaque);
	}

	protected void switchTo(SwitchablePanel newPanel) {
		this.mainFrame.switchPanels(newPanel);
	}

	protected Window getMainFrame() {
		return mainFrame;
	}

}
