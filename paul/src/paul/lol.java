package paul;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class lol extends JFrame
{
	private static final long serialVersionUID = 1L;
	private JTextField addressBar;
	private JEditorPane display;
	
	public lol()
	{
		super("Bucky Browser");
		System.getProperties().put("http.proxyHost", "172.16.30.20");
		System.getProperties().put("http.proxyPort", "8080");
		System.getProperties().put("http.proxyUser", "NITS");
		System.getProperties().put("http.proxyPassword", "abcde");
		addressBar= new JTextField("enter a URL host!");
		addressBar.addActionListener
		(
				new ActionListener()
				{
					public void actionPerformed(ActionEvent event)
					{	
						loadCrap(event.getActionCommand());
					}
				}
		);
		add(addressBar, BorderLayout.NORTH);
		display=new JEditorPane();
		display.setEditable(false);
		display.addHyperlinkListener
		(
				new HyperlinkListener()
				{
					public void hyperlinkUpdate(HyperlinkEvent event)
					{
						if(event.getEventType()==HyperlinkEvent.EventType.ACTIVATED)
						{
							loadCrap(event.getURL().toString());
						}
					}
				}
		);
		add(new JScrollPane(display), BorderLayout.CENTER);
		setSize(500,300);
		setVisible(true);
	}
	private void loadCrap(String userText)
	{
		try
		{
			display.setPage(userText);
			addressBar.setText(userText);
		}
		catch(Exception e)
		{
			System.out.println("crap!");
		}
	}
}
