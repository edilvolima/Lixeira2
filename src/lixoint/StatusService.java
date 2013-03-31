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
public class StatusService extends Service {
    
    //
    
       
    public static final String PLASTICO = "statusControlePlastico";
    public static final String OLEO = "statusControleOleo";
    public static final String VIDRO = "StatusControleVidro";
    
    private Lixeira application;
    
    @SuppressWarnings("serial")
    public StatusService (final Widget widget, Lixeira application) {
        super(widget, "StatusService",
                        new FunctionDescriptions() {
                                { // Contrutor 
                                // Define as funções do serviço descritos no Enactor
                                add(new FunctionDescription(
                                            PLASTICO,
                                            "Muda o status da Lixeira de Plasticos",
                                            widget.getNonConstantAttributes(),
                                            FunctionDescription.FUNCTION_SYNC));
                                /*add(new FunctionDescription(
                                            OLEO,
                                            "Muda o status da Lixeira de Oleo",
                                            widget.getNonConstantAttributes(),
                                            FunctionDescription.FUNCTION_SYNC));
                                add (new FunctionDescription(
                                            VIDRO,
                                            "Muda o status da Lixeira de Vidro",
                                            widget.getNonConstantAttributes(),
                                            FunctionDescription.FUNCTION_SYNC));*/
                                            
                                }
                        });
        this.application = application;
    }
    
    @Override
    public DataObject execute(ServiceInput serviceInput) {
		String functionName = serviceInput.getFunctionName();
		
		if (functionName.equals(PLASTICO)) {
			int status = serviceInput.getInput().getAttributeValue("status");
			application.setStatusPlastico(status);
		}
		/*
		else if (functionName.equals(OLEO)) {
                        int status = serviceInput.getInput().getAttributeValue("status");	
                        application.setStatusOleo(status);
		}
                
                else if (functionName.equals(VIDRO)) {
                        int status = serviceInput.getInput().getAttributeValue("status");
                        application.setStatusVidro(status);
                }
		*/
		return new DataObject(); // no particular info to return
	}
}
    
    
