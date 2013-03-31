/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lixoint;

import context.arch.comm.DataObject;
import context.arch.service.Service;
import context.arch.service.helper.FunctionDescription;
import context.arch.service.helper.FunctionDescriptions;
import context.arch.service.helper.ServiceInput;
import context.arch.widget.Widget;

/**
 *
 * @author Zeff
 */
public class MensagemService extends Service {
    
    //
    
       
    public static final String LIMITE = "mensagemLimite";
    public static final String AGENTE = "mensagemBuscaAgente";
    
    private Lixeira application;
    
    @SuppressWarnings("serial")
    public MensagemService (final Widget widget, Lixeira application) {
        super(widget, "MensagemService",
                        new FunctionDescriptions() {
                                { // Contrutor 
                                // Define as funções do serviço descritos no Enactor EnactorColeta
                                add(new FunctionDescription(
                                            LIMITE,
                                            "Avisa que a Lixeira está no seu limiar para chamar o Agente Coletor",
                                            widget.getNonConstantAttributes(),
                                            FunctionDescription.FUNCTION_SYNC));
                                add(new FunctionDescription(
                                            AGENTE,
                                            "Avisa que está chamando o Agente mais proximo",
                                            widget.getNonConstantAttributes(),
                                            FunctionDescription.FUNCTION_SYNC));                                        
                                }
                        });
            this.application = application;
    }
    
    @Override
    public DataObject execute(ServiceInput serviceInput) {
		String functionName = serviceInput.getFunctionName();
		
		if (functionName.equals(LIMITE)) {
			int mensagem = serviceInput.getInput().getAttributeValue("mensagem");
                        application.printMensagem(mensagem);
		}
		
		else if (functionName.equals(AGENTE)) {
                        int mensagem = serviceInput.getInput().getAttributeValue("mensagem");	
                        application.printMensagem(mensagem);
		}
                
		return new DataObject(); // no particular info to return
	}
}
    
    
