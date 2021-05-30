package one.digital.web.stdercorretora.exceptions;

import one.digital.web.stdercorretora.util.MessageUtils;

public class NotFoundException extends RuntimeException{

    public NotFoundException(){
        super(MessageUtils.NO_RECORDS_FOUND);
    }
}
