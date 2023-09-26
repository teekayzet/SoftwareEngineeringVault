public class DepositSlot {
   private boolean envelopeReceived; // whether envelope was received
   
   // constructor
   public DepositSlot() {
      envelopeReceived = false; // no envelope received initially
   } 

   // receive envelope
   public void receiveEnvelope() {
      envelopeReceived = true; // set envelopeReceived to true
   } 

   // check if envelope was received
   public boolean isEnvelopeReceived() {
      return envelopeReceived; // return envelopeReceived status
   } 
}
