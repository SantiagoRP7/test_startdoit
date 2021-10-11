/**
 * 
 */
package com.n_in_line.ctrl;

import java.util.Vector;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.HtmlBasedComponent;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.SerializableEventListener;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zkmax.ui.util.Toast;
import org.zkoss.zkmax.zul.Tablechildren;
import org.zkoss.zkmax.zul.Tablelayout;
import org.zkoss.zul.Button;
import org.zkoss.zul.Cell;
import org.zkoss.zul.Div;
import org.zkoss.zul.Intbox;
import org.zkoss.zul.Label;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.impl.LabelElement;

/**
 * @author sanrop
 *
 */


public class n_table_ctrl extends GenericForwardComposer {
			
	private Div divMain;
	private Textbox player1;
	private Textbox player2;
	private Intbox nIntBox;
	private Button initGameButton ;
	private Button newGame;
	
	private Tablelayout table;
	private Tablechildren[][] tableChilds;
	private ButtonCell[][] cells;
	private boolean turno = true;
	private int n;

	
	@Override
	public void doAfterCompose(Component comp) throws Exception {
			super.doAfterCompose(comp);
			EventListener<Event> initGameListener = new EventListener<Event>() {

				@Override
				public void onEvent(Event event) throws Exception {
					if(event.getTarget().getId() == "newGame") {
						divMain.removeChild(table);
						table.setVisible(false);
					}else {
						
					}
					startGame();						
				}
			};
			initGameButton.addEventListener("onClick", initGameListener);
			//newGame.addEventListener("onClick", initGameListener);
	}
	
	public void startGame() {
		initGameButton.setDisabled(true);
		player1.setDisabled(true);
		player2.setDisabled(true);
		nIntBox.setDisabled(false);
		
		EventListener<Event> cellsListener = new SerializableEventListener<Event>() {
			private static final long serialVersionUID = 1L;
			@Override
			public void onEvent(Event event) throws Exception {
				ButtonCell labelButtonPressed = ((ButtonCell) event.getTarget());
				
				String player="X";
				if(turno && labelButtonPressed.getLabel() == "") {	
					player = "X";
					
					labelButtonPressed.setLabel(player);
					
				}else if(labelButtonPressed.getLabel() == "") {
					player = "O";
					
					labelButtonPressed.setLabel(player);
				}
				labelButtonPressed.setDisabled(true);
				turno = !turno;
				gameOver(labelButtonPressed);
				
				
			}
		};
		
		
		n =nIntBox.getValue();
		cells = new ButtonCell[n][n];
		tableChilds = new Tablechildren[n][n];
		table = new Tablelayout();
		table.setColumns(n);
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				tableChilds[i][j] = new Tablechildren();
				tableChilds[i][j].setStyle("width: 20px; height:30px; border: 2.5px solid #555;");
				ButtonCell tempButton = new ButtonCell();
				tempButton.addEventListener("onClick", cellsListener);
				tempButton.updatePos(i,j);	
				cells[i][j] = (tempButton);
				cells[i][j].setStyle("border: 2.5px solid; background-color:#fff;width:100%; height:100%;");
				cells[i][j].setLabel("");
				cells[i][j].getLabel();
				table.appendChild(tableChilds[i][j]);
				tableChilds[i][j].appendChild(cells[i][j]);
			}
		}
		
		divMain.appendChild(table);
		
	}
	
	public void newGame() {
		table.detach();
		startGame();
	}
	
	public void gameOver(ButtonCell cell) {
		int i = cell.i;
		int j = cell.j;
		int searchs=3;
		int counter=0;
		if(i!=j) {
			searchs=2;
		}
		for(int k=0;k<searchs;k++) {
			counter=0;
			for(int l=0;l<n;l++){
				if(k==0) {
					if(cells[i][l].getLabel() == cell.getLabel()) {
						counter++;
					}
				}else if(k==1) {
					if(cells[l][j].getLabel() == cell.getLabel()) {
						counter++;
					}
				}else {
					if(cells[l][l].getLabel() == cell.getLabel()) {
						counter++;
					}
				}
			}
			if(counter == n) {
				String ganador;
				if(cell.getLabel()=="X") {
					ganador = player1.getText();
				}else {
					ganador = player2.getText();
				}
				System.out.println(ganador+" a ganado! felicitaciones.");
				Toast.show(ganador+" a ganado! felicitaciones.", "info",null, 0, true);
				for(int a=0;a<n;a++) {
					for(int b=0;b<n;b++) {
						cells[a][b].setDisabled(true);
					}
				}
				break;
			}
		}
		counter =0;
		for(int c=0;c<n;c++) {
			for(int d=0;d<n;d++) {
				if(cells[c][d].getLabel() != "") {
					counter++;
				}
			}
		}
		if(counter== n*n) {
			//System.out.println(cell.getLabel()+" a ganado! felicitaciones.");
			Toast.show("Es un empate.", "warning",null, 0, true);
		}
	}
	
	
}
