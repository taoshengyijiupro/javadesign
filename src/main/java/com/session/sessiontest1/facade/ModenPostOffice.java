package com.session.sessiontest1.facade;

public class ModenPostOffice {
    private LetterProcess letterProcess = new LetterProcessImpl();
    //private Police letterPolice = new Police();


    public void sendLetter(String context, String address) {
        //帮你写信
        letterProcess.writeContext(context);

        //写好信封
        letterProcess.fillEnvelope(address);

        //letterPolice.checkLetter(letterProcess);

        //把信放到信封中
        letterProcess.letterInotoEnvelope();

        letterProcess.sendLetter();

    }
}
