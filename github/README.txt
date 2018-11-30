ti ho messo il model e il diagramma delle interfacce aggiornato. Ti ho mandato sia l' immagine .png, sia il file in formato starUML così puoi modificarlo se vuoi.

ho unito Segreteria e Clinica, il vecchio diagramma delle classi era sbagliato concettualmente.
non ho implementato niente per quanto riguarda il cambiamento di stato della prestazione. sarà da gestire nel controller.
non ho implementato un sistema che genera prestazioni in automatico ma sarebbe da fare, ma penso che ci serva la parte di database prima. la funzione addPrestazione c'è.
ho dovuto rimettere la classe macchinario visto che a mio zio serve sapere quando ha la disponibilità dei macchinari per certe visite.
nel controller dobbiamo ricordarci di restringere la getLista dei dottori e della classe account.
nel controller sarebbe comodo fare alcune funzioni che generano in automatico il codice di una prestazione, dei macchinari e l' id del dottore.


//TODO: -devo capire come fare setPrenotazione() nella classe Account, che sarebbe la ricerca, che sarebbe l' utilità di questo sistema.
        -ho messo il serialUID a 1 in tutte le classi, dobbiamo serializzare poi da linea di comando.
        -mancano i delete. penso che dobbiamo fare la parte di database per quello, anche per quanto riguarda gli add, bisognerà farlo nel controller.
                  ci si mette poco comunque, le funzioni di add e delete sono le stesse per come abbiamo organizzato il progetto.
