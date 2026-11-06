package livelock;

public class Herramienta { //Martillo y destornillador, la herramientav puede estar libre o no
	//El trabajador intentaará coger la herramienta
	
	private boolean libre = true;

    public synchronized boolean coger() {
        if (!libre) {
            return false; //Si no está libre no la ha podido coger
        }
        libre = false; //Si la ha cogido ya no está libre
        return true;
    }

    public synchronized void soltar() {
        libre = true;
    }

}
