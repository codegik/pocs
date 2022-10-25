package com.lendingclub.bankgateway.cohesion.util;

import com.lendingclub.bankgateway.cohesion.soap.FIELD;
import com.lendingclub.bankgateway.cohesion.soap.GetHostReplyResponse;
import com.lendingclub.bankgateway.cohesion.soap.GetHostReplyResult;
import com.lendingclub.bankgateway.cohesion.soap.HeaderData;
import com.lendingclub.bankgateway.cohesion.soap.InputField;
import com.lendingclub.bankgateway.cohesion.soap.MiserXMLReply;

import java.util.Arrays;
import java.util.List;

public class DataUtil {

    public static InputField gimmeInputField(int fieldNbr, String fieldData, String fieldName, String fieldDesc) {
        final InputField inputField = new InputField();

        inputField.setFieldNbr(fieldNbr);
        inputField.setFieldData(fieldData);
        inputField.setFieldName(fieldName);
        inputField.setFieldDesc(fieldDesc);

        return inputField;
    }

    public static List<InputField> gimmeDefaultInputFieldList() {
        return Arrays.asList(
                gimmeInputField(00462001, "000122012346", "IMT-ACCT-NBR(01)", "Donor Account(01)"),
                gimmeInputField(00461001, "10", "IMT-APPL-CODE(01)", "Donor Application(01)"),
                gimmeInputField(00463001, "1", "IMT-TRAN-AMT(01)", "Transaction Amount(01)"),
                gimmeInputField(00464, null, "IMT-EFF-DT", "Effective Date"),
                gimmeInputField(00462002, "000122012345", "IMT-ACCT-NBR(02)", "Recipient Account(02)"),
                gimmeInputField(00461002, "10", "IMT-APPL-CODE(02)", "Recipient Application(02)"),
                gimmeInputField(00465001, null, "IMT-MISC-ID(01)", "Miscellaneous ID (debit)(01)"),
                gimmeInputField(00466, null, "IMT-DESC", "Description"),
                gimmeInputField(00465002, null, "IMT-MISC-ID(02)", " Miscellaneous ID (credit)(02)"),
                gimmeInputField(00467001, null, "IMT-TRCD-OVR(01)", "Tran Code Indicator 1(01)"),
                gimmeInputField(00467002, null, "IMT-TRCD-OVR(02)", "Tran Code Indicator 2(02)")
        );
    }

    public static GetHostReplyResponse gimmeHostReplyResponse() {
        final GetHostReplyResponse response = new GetHostReplyResponse();
        final GetHostReplyResult result = new GetHostReplyResult();
        final MiserXMLReply miserXMLReply = new MiserXMLReply();
        final HeaderData headerData = new HeaderData();
        final FIELD field = new FIELD();

        headerData.setApplicationCode("MS");
        headerData.setTransactionCode("XT$");
        headerData.setPosition(1);
        field.setFieldData("7");
        field.setFieldNbr(00467001);
        miserXMLReply.setHeaderData(headerData);
        miserXMLReply.setFIELD(field);
        result.setMiserXMLReply(miserXMLReply);
        response.setGetHostReplyResult(result);

        return response;
    }
}
