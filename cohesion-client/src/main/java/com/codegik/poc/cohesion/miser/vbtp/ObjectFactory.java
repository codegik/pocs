
package com.codegik.poc.cohesion.miser.vbtp;

import java.math.BigDecimal;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.codegik.poc.cohesion.miser.vbtp package.
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _FaxNbr_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "FaxNbr");
    private final static QName _YTDStateHold_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "YTDStateHold");
    private final static QName _FailDate_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "FailDate");
    private final static QName _ATMODInd_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "ATMODInd");
    private final static QName _CellNoSol_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "CellNoSol");
    private final static QName _AvgUnusedBal_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "AvgUnusedBal");
    private final static QName _TotChkHoldAmt_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "TotChkHoldAmt");
    private final static QName _RunningBal_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "RunningBal");
    private final static QName _MaxLoanLimit_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "MaxLoanLimit");
    private final static QName _EchoHistDate_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "EchoHistDate");
    private final static QName _AccruIntDate_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "AccruIntDate");
    private final static QName _TransferFlag_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "TransferFlag");
    private final static QName _LastCalcDate_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "LastCalcDate");
    private final static QName _CMBAccess_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "CMBAccess");
    private final static QName _TotalCreditAmt_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "TotalCreditAmt");
    private final static QName _IntMethodFlag_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "IntMethodFlag");
    private final static QName _FindRelCode_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "FindRelCode");
    private final static QName _NameAddrLine1_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "NameAddrLine1");
    private final static QName _HoldAmt_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "HoldAmt");
    private final static QName _AvailIntAmt_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "AvailIntAmt");
    private final static QName _NameAddrLine3_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "NameAddrLine3");
    private final static QName _NameAddrLine2_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "NameAddrLine2");
    private final static QName _CheckNbrorAmt_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "CheckNbrorAmt");
    private final static QName _CIBAccess_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "CIBAccess");
    private final static QName _LastDepositDate_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "LastDepositDate");
    private final static QName _NameAddrLine5_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "NameAddrLine5");
    private final static QName _NameAddrLine4_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "NameAddrLine4");
    private final static QName _NextBillDate_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "NextBillDate");
    private final static QName _OrigAmt_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "OrigAmt");
    private final static QName _TotATMHrdHoldAmt_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "TotATMHrdHoldAmt");
    private final static QName _CIFAcctNbr_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "CIFAcctNbr");
    private final static QName _MinCheckAmt_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "MinCheckAmt");
    private final static QName _FaxConsentCode_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "FaxConsentCode");
    private final static QName _PayMethod_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "PayMethod");
    private final static QName _LastPmtIns_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "LastPmtIns");
    private final static QName _CheckNbr_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "CheckNbr");
    private final static QName _IntCalcDate_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "IntCalcDate");
    private final static QName _EmailAddr_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "EmailAddr");
    private final static QName _LastPmtInt_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "LastPmtInt");
    private final static QName _OpenReason_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "OpenReason");
    private final static QName _KICode_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "KICode");
    private final static QName _DescCode_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "DescCode");
    private final static QName _ActionCode_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "ActionCode");
    private final static QName _AddtlInfo_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "AddtlInfo");
    private final static QName _DeliveryAddr_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "DeliveryAddr");
    private final static QName _AltNameAddr_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "AltNameAddr");
    private final static QName _VBRInd_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "VBRInd");
    private final static QName _PriorYearEscrowInt_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "PriorYearEscrowInt");
    private final static QName _OrigDate_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "OrigDate");
    private final static QName _PendingTrxFlag_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "PendingTrxFlag");
    private final static QName _Merchant_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "Merchant");
    private final static QName _AddrSource_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "AddrSource");
    private final static QName _CustTypeCode_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "CustTypeCode");
    private final static QName _PrevYTDFeesPaid_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "PrevYTDFeesPaid");
    private final static QName _CurrYrEarnAmt_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "CurrYrEarnAmt");
    private final static QName _TranDesc_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "TranDesc");
    private final static QName _CreditLimit_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "CreditLimit");
    private final static QName _ContributionCode_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "ContributionCode");
    private final static QName _TranOptCode_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "TranOptCode");
    private final static QName _MultipleSig_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "MultipleSig");
    private final static QName _TotMgmtHoldAmt_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "TotMgmtHoldAmt");
    private final static QName _EndDate_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "EndDate");
    private final static QName _TranCdLastPmt_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "TranCdLastPmt");
    private final static QName _CustName_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "CustName");
    private final static QName _UncollAmt_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "UncollAmt");
    private final static QName _DtLastPmt_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "DtLastPmt");
    private final static QName _DLNbr_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "DLNbr");
    private final static QName _PAN_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "PAN");
    private final static QName _PostDate_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "PostDate");
    private final static QName _TranAcctInd_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "TranAcctInd");
    private final static QName _PrimeRateVar_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "PrimeRateVar");
    private final static QName _Email_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "Email");
    private final static QName _DepositYearInd_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "DepositYearInd");
    private final static QName _APYCalc_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "APYCalc");
    private final static QName _DescPart5_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "DescPart5");
    private final static QName _ExpireDate_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "ExpireDate");
    private final static QName _DescPart4_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "DescPart4");
    private final static QName _CheckNbr1_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "CheckNbr1");
    private final static QName _BusConsentCode_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "BusConsentCode");
    private final static QName _LastDepDate_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "LastDepDate");
    private final static QName _CheckNbr2_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "CheckNbr2");
    private final static QName _OverlineLimit_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "OverlineLimit");
    private final static QName _TotTrans_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "TotTrans");
    private final static QName _RptCode1098_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "RptCode1098");
    private final static QName _CarryoverInt_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "CarryoverInt");
    private final static QName _DescPart3_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "DescPart3");
    private final static QName _DescPart2_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "DescPart2");
    private final static QName _DescPart1_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "DescPart1");
    private final static QName _DBCODInd_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "DBCODInd");
    private final static QName _UsedBal_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "UsedBal");
    private final static QName _TranTime_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "TranTime");
    private final static QName _NbrDep_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "NbrDep");
    private final static QName _IntColCode_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "IntColCode");
    private final static QName _PriorYearTaxPaid_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "PriorYearTaxPaid");
    private final static QName _ForeignPrefixFax_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "ForeignPrefixFax");
    private final static QName _LastIntAmt_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "LastIntAmt");
    private final static QName _AcctTitle_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "AcctTitle");
    private final static QName _SkipPayment_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "SkipPayment");
    private final static QName _Term_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "Term");
    private final static QName _LastDisbAmt_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "LastDisbAmt");
    private final static QName _LastIntPaidDate_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "LastIntPaidDate");
    private final static QName _TotalLoansAttached_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "TotalLoansAttached");
    private final static QName _LineOfficer_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "LineOfficer");
    private final static QName _RegDLimitFlag_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "RegDLimitFlag");
    private final static QName _ATMAcctNbr_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "ATMAcctNbr");
    private final static QName _State_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "State");
    private final static QName _CellConsentDt_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "CellConsentDt");
    private final static QName _PassbookStmtInd_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "PassbookStmtInd");
    private final static QName _LastStmtBal_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "LastStmtBal");
    private final static QName _FindCIFNbr_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "FindCIFNbr");
    private final static QName _DaysPastDueDt_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "DaysPastDueDt");
    private final static QName _TotalOutstandingAmt_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "TotalOutstandingAmt");
    private final static QName _PendTranFlag_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "PendTranFlag");
    private final static QName _TranCode2_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "TranCode2");
    private final static QName _PriApplCode_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "PriApplCode");
    private final static QName _EffDate_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "EffDate");
    private final static QName _TranCode1_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "TranCode1");
    private final static QName _YTDFederalHold_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "YTDFederalHold");
    private final static QName _FWYtdAmt_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "FWYtdAmt");
    private final static QName _XderAppl_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "XderAppl");
    private final static QName _ApplicationCode1_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "ApplicationCode1");
    private final static QName _ApplCode2_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "ApplCode2");
    private final static QName _ApplCode1_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "ApplCode1");
    private final static QName _ReturnSeq_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "ReturnSeq");
    private final static QName _UnColAmtRemain_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "UnColAmtRemain");
    private final static QName _LastPmtLtChg_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "LastPmtLtChg");
    private final static QName _TotalDisbReq_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "TotalDisbReq");
    private final static QName _HistSeqNbr_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "HistSeqNbr");
    private final static QName _PrepaidInt_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "PrepaidInt");
    private final static QName _ScreenName_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "ScreenName");
    private final static QName _LineTypeCode_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "LineTypeCode");
    private final static QName _PrevMaturityAmt_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "PrevMaturityAmt");
    private final static QName _ForeignPrefixHomePhone_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "ForeignPrefixHomePhone");
    private final static QName _ServicerNbr2_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "ServicerNbr2");
    private final static QName _ServicerNbr1_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "ServicerNbr1");
    private final static QName _EmpCode_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "EmpCode");
    private final static QName _BusPhone_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "BusPhone");
    private final static QName _PrBalance_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "PrBalance");
    private final static QName _NoteDate_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "NoteDate");
    private final static QName _LineUnusedAmt_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "LineUnusedAmt");
    private final static QName _TranOpt_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "TranOpt");
    private final static QName _LastPmtMisc_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "LastPmtMisc");
    private final static QName _TranHistKey_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "TranHistKey");
    private final static QName _LateChgAmt_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "LateChgAmt");
    private final static QName _LastIntDate_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "LastIntDate");
    private final static QName _PrevYTDIntPaid_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "PrevYTDIntPaid");
    private final static QName _BusConsentDt_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "BusConsentDt");
    private final static QName _TranType_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "TranType");
    private final static QName _AcctNbr_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "AcctNbr");
    private final static QName _TotHoldAmt_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "TotHoldAmt");
    private final static QName _NextIntDate_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "NextIntDate");
    private final static QName _ApplicationCode_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "ApplicationCode");
    private final static QName _ApplCode_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "ApplCode");
    private final static QName _OtherFlag_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "OtherFlag");
    private final static QName _XferAcct_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "XferAcct");
    private final static QName _AddtlAddr_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "AddtlAddr");
    private final static QName _EmailConsentDt_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "EmailConsentDt");
    private final static QName _HoldName_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "HoldName");
    private final static QName _UnappliedAmt_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "UnappliedAmt");
    private final static QName _ACHSeqNbr_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "ACHSeqNbr");
    private final static QName _LateChgTotal_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "LateChgTotal");
    private final static QName _HistorySeqNbr_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "HistorySeqNbr");
    private final static QName _StmtCycleCode_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "StmtCycleCode");
    private final static QName _LastEarnPaidDate_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "LastEarnPaidDate");
    private final static QName _SelectionOpt_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "SelectionOpt");
    private final static QName _LastBillDate_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "LastBillDate");
    private final static QName _LastAcctNbr_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "LastAcctNbr");
    private final static QName _AccountNbr_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "AccountNbr");
    private final static QName _YTDIntPaid_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "YTDIntPaid");
    private final static QName _ClosingFee_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "ClosingFee");
    private final static QName _CardClassDesc_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "CardClassDesc");
    private final static QName _MaxNoteAmt_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "MaxNoteAmt");
    private final static QName _RMBAccess_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "RMBAccess");
    private final static QName _Teller_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "Teller");
    private final static QName _MinBal_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "MinBal");
    private final static QName _TotHoldLessCheckHoldAmt_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "TotHoldLessCheckHoldAmt");
    private final static QName _TaxID_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "TaxID");
    private final static QName _LocationCode_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "LocationCode");
    private final static QName _CellConsentCode_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "CellConsentCode");
    private final static QName _TotalAmt_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "TotalAmt");
    private final static QName _RestrictInd_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "RestrictInd");
    private final static QName _CancelInd_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "CancelInd");
    private final static QName _MaxOutstandingPr_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "MaxOutstandingPr");
    private final static QName _WDDate2_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "WDDate2");
    private final static QName _WDDate1_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "WDDate1");
    private final static QName _WDDate4_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "WDDate4");
    private final static QName _WDDate3_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "WDDate3");
    private final static QName _ConsentCode_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "ConsentCode");
    private final static QName _WDDate5_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "WDDate5");
    private final static QName _EffDtLastPmt_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "EffDtLastPmt");
    private final static QName _PrivacyInd_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "PrivacyInd");
    private final static QName _LastFMDate_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "LastFMDate");
    private final static QName _LastMonetaryTranDate_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "LastMonetaryTranDate");
    private final static QName _SWYtdAmt_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "SWYtdAmt");
    private final static QName _HistIndicator_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "HistIndicator");
    private final static QName _AcctClass_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "AcctClass");
    private final static QName _TellerNbr_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "TellerNbr");
    private final static QName _EscrowAmt_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "EscrowAmt");
    private final static QName _DocMethodCode_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "DocMethodCode");
    private final static QName _RemUncollAmt_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "RemUncollAmt");
    private final static QName _LastDepositAmt_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "LastDepositAmt");
    private final static QName _CFMCustNbr_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "CFMCustNbr");
    private final static QName _CompoundedInt_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "CompoundedInt");
    private final static QName _OpeningDate_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "OpeningDate");
    private final static QName _LockFlags_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "LockFlags");
    private final static QName _AccountNbr2_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "AccountNbr2");
    private final static QName _Amount_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "Amount");
    private final static QName _AccountNbr1_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "AccountNbr1");
    private final static QName _PrevMatDate_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "PrevMatDate");
    private final static QName _TaxIDType_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "TaxIDType");
    private final static QName _MultiSigFlag_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "MultiSigFlag");
    private final static QName _ForeignPrefixBusPhone_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "ForeignPrefixBusPhone");
    private final static QName _ForeignInd_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "ForeignInd");
    private final static QName _WarnCode2_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "WarnCode2");
    private final static QName _WarnCode1_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "WarnCode1");
    private final static QName _PrimeRateCode_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "PrimeRateCode");
    private final static QName _RetireFlag_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "RetireFlag");
    private final static QName _EchoHistBal_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "EchoHistBal");
    private final static QName _AvailBal_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "AvailBal");
    private final static QName _MinDrawAmt_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "MinDrawAmt");
    private final static QName _ToDate_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "ToDate");
    private final static QName _StmtCombAcct_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "StmtCombAcct");
    private final static QName _LastActivityDate_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "LastActivityDate");
    private final static QName _LastBillDt_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "LastBillDt");
    private final static QName _PrimeRateVarCode_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "PrimeRateVarCode");
    private final static QName _TransferReceiptFlag_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "TransferReceiptFlag");
    private final static QName _TranDate_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "TranDate");
    private final static QName _LateDays_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "LateDays");
    private final static QName _DateOpen_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "DateOpen");
    private final static QName _HistTranType_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "HistTranType");
    private final static QName _Result_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "Result");
    private final static QName _LastDepAmt_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "LastDepAmt");
    private final static QName _RefType_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "RefType");
    private final static QName _PmtTypeFlag_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "PmtTypeFlag");
    private final static QName _CarryoverDate_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "CarryoverDate");
    private final static QName _DisbAmt_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "DisbAmt");
    private final static QName _XferFlag_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "XferFlag");
    private final static QName _PropTaxDueDt_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "PropTaxDueDt");
    private final static QName _HoldType_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "HoldType");
    private final static QName _YTDAvgBal_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "YTDAvgBal");
    private final static QName _City_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "City");
    private final static QName _StmtFlag_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "StmtFlag");
    private final static QName _LostInd_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "LostInd");
    private final static QName _NumAccounts_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "NumAccounts");
    private final static QName _TotalDebitAmt_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "TotalDebitAmt");
    private final static QName _InfoAttn_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "InfoAttn");
    private final static QName _OpeningAmt_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "OpeningAmt");
    private final static QName _PYTDIntPaid_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "PYTDIntPaid");
    private final static QName _RenewalDt_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "RenewalDt");
    private final static QName _LateCharge_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "LateCharge");
    private final static QName _InsCharge_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "InsCharge");
    private final static QName _AcctDesc_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "AcctDesc");
    private final static QName _CardType_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "CardType");
    private final static QName _TicklerCode_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "TicklerCode");
    private final static QName _FailCount_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "FailCount");
    private final static QName _PmtTypeFlag2_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "PmtTypeFlag2");
    private final static QName _DueDate_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "DueDate");
    private final static QName _PayoffAmt_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "PayoffAmt");
    private final static QName _CountryCode_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "CountryCode");
    private final static QName _DirectDepositFlag_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "DirectDepositFlag");
    private final static QName _ReviewFreqCode_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "ReviewFreqCode");
    private final static QName _TranAmt_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "TranAmt");
    private final static QName _NamePrefix_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "NamePrefix");
    private final static QName _WDLimitFlag_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "WDLimitFlag");
    private final static QName _PendVBTPTransferFlag_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "PendVBTPTransferFlag");
    private final static QName _ProdCode_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "ProdCode");
    private final static QName _Error_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "Error");
    private final static QName _NbrChksCleared_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "NbrChksCleared");
    private final static QName _PYTDIntPd_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "PYTDIntPd");
    private final static QName _DBCODConfirmDate_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "DBCODConfirmDate");
    private final static QName _PostingDate_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "PostingDate");
    private final static QName _MinDrawAmt2_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "MinDrawAmt2");
    private final static QName _PrevYearYTDInt_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "PrevYearYTDInt");
    private final static QName _AnnualIncome_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "AnnualIncome");
    private final static QName _EffectiveDate_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "EffectiveDate");
    private final static QName _PropType_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "PropType");
    private final static QName _IntCalcCode_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "IntCalcCode");
    private final static QName _PANType_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "PANType");
    private final static QName _CIFNbr_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "CIFNbr");
    private final static QName _LastCIFNbr_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "LastCIFNbr");
    private final static QName _BufferStartBal_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "BufferStartBal");
    private final static QName _AccrIntonEsc_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "AccrIntonEsc");
    private final static QName _PrBal_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "PrBal");
    private final static QName _NumHistTran_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "NumHistTran");
    private final static QName _ReleaseDt_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "ReleaseDt");
    private final static QName _Comment1_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "Comment1");
    private final static QName _Comment2_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "Comment2");
    private final static QName _FundsType_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "FundsType");
    private final static QName _OwnerCIFNbr_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "OwnerCIFNbr");
    private final static QName _PrevYrEarnAmt_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "PrevYrEarnAmt");
    private final static QName _LineInvPct_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "LineInvPct");
    private final static QName _PinOffset_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "PinOffset");
    private final static QName _RelCode_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "RelCode");
    private final static QName _YTDIntPd_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "YTDIntPd");
    private final static QName _EmbossName2_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "EmbossName2");
    private final static QName _EmbossName1_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "EmbossName1");
    private final static QName _NextBillDt_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "NextBillDt");
    private final static QName _RegPlanFlag_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "RegPlanFlag");
    private final static QName _DeceasedDt_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "DeceasedDt");
    private final static QName _NbrTrans_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "NbrTrans");
    private final static QName _OwnRentInd_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "OwnRentInd");
    private final static QName _MaxHistReply_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "MaxHistReply");
    private final static QName _LastPmtDate_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "LastPmtDate");
    private final static QName _TotCollatHoldAmt_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "TotCollatHoldAmt");
    private final static QName _YTDInt_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "YTDInt");
    private final static QName _FWPrevYtdAmt_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "FWPrevYtdAmt");
    private final static QName _LastPmtOther_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "LastPmtOther");
    private final static QName _AccruInt_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "AccruInt");
    private final static QName _NameAddrCode5_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "NameAddrCode5");
    private final static QName _StatementDate_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "StatementDate");
    private final static QName _TraceNbr_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "TraceNbr");
    private final static QName _WarnFlag_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "WarnFlag");
    private final static QName _NameAddrCode1_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "NameAddrCode1");
    private final static QName _NameAddrCode2_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "NameAddrCode2");
    private final static QName _CollectionsFlag_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "CollectionsFlag");
    private final static QName _NameAddrCode3_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "NameAddrCode3");
    private final static QName _NameAddrCode4_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "NameAddrCode4");
    private final static QName _IntMethod_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "IntMethod");
    private final static QName _LastStmtDate_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "LastStmtDate");
    private final static QName _CFMCustNbrType_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "CFMCustNbrType");
    private final static QName _ExpDate_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "ExpDate");
    private final static QName _LedgerBal_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "LedgerBal");
    private final static QName _RetItemFee_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "RetItemFee");
    private final static QName _ReasonCode1_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "ReasonCode1");
    private final static QName _OrderNbr_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "OrderNbr");
    private final static QName _ReasonCode2_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "ReasonCode2");
    private final static QName _WarnFlags_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "WarnFlags");
    private final static QName _YTDTaxPd_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "YTDTaxPd");
    private final static QName _StatusInd_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "StatusInd");
    private final static QName _SelectionInd_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "SelectionInd");
    private final static QName _FirstName_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "FirstName");
    private final static QName _LastEarnPaidAmt_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "LastEarnPaidAmt");
    private final static QName _PrevYTDTaxes_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "PrevYTDTaxes");
    private final static QName _LastPmtAmt_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "LastPmtAmt");
    private final static QName _EvalAcctStatus_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "EvalAcctStatus");
    private final static QName _EmpFlag_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "EmpFlag");
    private final static QName _PriAcctNbr_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "PriAcctNbr");
    private final static QName _DueDt_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "DueDt");
    private final static QName _EmailSeq_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "EmailSeq");
    private final static QName _EffHistDate_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "EffHistDate");
    private final static QName _HistSeqInd_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "HistSeqInd");
    private final static QName _LastIntPaidAmt_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "LastIntPaidAmt");
    private final static QName _ATMODConfirmDate_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "ATMODConfirmDate");
    private final static QName _PhoneExt_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "PhoneExt");
    private final static QName _UnColAmt1Day_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "UnColAmt1Day");
    private final static QName _BusPhoneExt_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "BusPhoneExt");
    private final static QName _ContactType_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "ContactType");
    private final static QName _YTDIntPenalty_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "YTDIntPenalty");
    private final static QName _ReviewDate_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "ReviewDate");
    private final static QName _PlacedDate_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "PlacedDate");
    private final static QName _RptFlag1098_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "RptFlag1098");
    private final static QName _TranSource_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "TranSource");
    private final static QName _TranCountRegD_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "TranCountRegD");
    private final static QName _PrevYearYTDIntPenalty_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "PrevYearYTDIntPenalty");
    private final static QName _CIFNameLine1_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "CIFNameLine1");
    private final static QName _CardTypeCode_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "CardTypeCode");
    private final static QName _HistDate_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "HistDate");
    private final static QName _HomeNoSol_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "HomeNoSol");
    private final static QName _DBCODPostDate_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "DBCODPostDate");
    private final static QName _HistBuffers_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "HistBuffers");
    private final static QName _IntCalcBasis_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "IntCalcBasis");
    private final static QName _TotalOutstandingPrevAmt_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "TotalOutstandingPrevAmt");
    private final static QName _LoanAcctNbrLink_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "LoanAcctNbrLink");
    private final static QName _ServicerNumber1_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "ServicerNumber1");
    private final static QName _PhoneNbr_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "PhoneNbr");
    private final static QName _DenialCode_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "DenialCode");
    private final static QName _AcctType_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "AcctType");
    private final static QName _AudioAccess_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "AudioAccess");
    private final static QName _LastStmtDt_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "LastStmtDt");
    private final static QName _DateOpened_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "DateOpened");
    private final static QName _HomeConsentCode_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "HomeConsentCode");
    private final static QName _IntRate_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "IntRate");
    private final static QName _HouseholdNbr_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "HouseholdNbr");
    private final static QName _LastApplCode_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "LastApplCode");
    private final static QName _OtherAmt_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "OtherAmt");
    private final static QName _ForeignPrefixCellPhone_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "ForeignPrefixCellPhone");
    private final static QName _TaxType_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "TaxType");
    private final static QName _UserNbr6_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "UserNbr6");
    private final static QName _UserNbr5_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "UserNbr5");
    private final static QName _UserNbr4_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "UserNbr4");
    private final static QName _UserNbr3_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "UserNbr3");
    private final static QName _SubAcctType_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "SubAcctType");
    private final static QName _LastName_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "LastName");
    private final static QName _HomeConsentDt_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "HomeConsentDt");
    private final static QName _NumDebitTran_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "NumDebitTran");
    private final static QName _CollFlag_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "CollFlag");
    private final static QName _GraceCode_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "GraceCode");
    private final static QName _MaidenName_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "MaidenName");
    private final static QName _ReviewFlag_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "ReviewFlag");
    private final static QName _YTDFeesPaid_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "YTDFeesPaid");
    private final static QName _PrevYTDIntPenalty_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "PrevYTDIntPenalty");
    private final static QName _OrigCommitAmt_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "OrigCommitAmt");
    private final static QName _UserNbr2_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "UserNbr2");
    private final static QName _UserNbr1_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "UserNbr1");
    private final static QName _CellPhone_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "CellPhone");
    private final static QName _EmailConsentCode_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "EmailConsentCode");
    private final static QName _TranPAN_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "TranPAN");
    private final static QName _LangPref_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "LangPref");
    private final static QName _LastTranBranch_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "LastTranBranch");
    private final static QName _StmtCombAppl_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "StmtCombAppl");
    private final static QName _Branch_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "Branch");
    private final static QName _PrincipalAmt_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "PrincipalAmt");
    private final static QName _LastPmtEsc_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "LastPmtEsc");
    private final static QName _ZipCode_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "ZipCode");
    private final static QName _PANLength_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "PANLength");
    private final static QName _CustBal_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "CustBal");
    private final static QName _StateCode_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "StateCode");
    private final static QName _FaxConsentDt_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "FaxConsentDt");
    private final static QName _OrigLnAmt_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "OrigLnAmt");
    private final static QName _MthlyPmtAmt_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "MthlyPmtAmt");
    private final static QName _LockFlag_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "LockFlag");
    private final static QName _ReceiptNbr_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "ReceiptNbr");
    private final static QName _StolenInd_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "StolenInd");
    private final static QName _FaxNoSol_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "FaxNoSol");
    private final static QName _DVAdjust_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "DVAdjust");
    private final static QName _ServicerAccountNumber2_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "ServicerAccountNumber2");
    private final static QName _ServicerAccountNumber1_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "ServicerAccountNumber1");
    private final static QName _GraceDays_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "GraceDays");
    private final static QName _CarryoverEsc_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "CarryoverEsc");
    private final static QName _NoSolInd_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "NoSolInd");
    private final static QName _InterestAmt_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "InterestAmt");
    private final static QName _LastPmtEscInt_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "LastPmtEscInt");
    private final static QName _IntlPrefix_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "IntlPrefix");
    private final static QName _EscrowBal_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "EscrowBal");
    private final static QName _NonBalAmt_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "NonBalAmt");
    private final static QName _PayoffBal_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "PayoffBal");
    private final static QName _SeqNbr_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "SeqNbr");
    private final static QName _RIBAccess_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "RIBAccess");
    private final static QName _PINNbr_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "PINNbr");
    private final static QName _PassbookStmtCode_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "PassbookStmtCode");
    private final static QName _FeePaymentDueDt_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "FeePaymentDueDt");
    private final static QName _FindMailOrder_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "FindMailOrder");
    private final static QName _XferCode_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "XferCode");
    private final static QName _TotAmtDue_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "TotAmtDue");
    private final static QName _LockCode1_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "LockCode1");
    private final static QName _UpdateMonth_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "UpdateMonth");
    private final static QName _LockCode2_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "LockCode2");
    private final static QName _YTDEscrowInt_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "YTDEscrowInt");
    private final static QName _ODAvailBal_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "ODAvailBal");
    private final static QName _EscrowInt_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "EscrowInt");
    private final static QName _LastOrderNbr_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "LastOrderNbr");
    private final static QName _TermFormatCode_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "TermFormatCode");
    private final static QName _FromDate_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "FromDate");
    private final static QName _YTDTaxes_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "YTDTaxes");
    private final static QName _Country_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "Country");
    private final static QName _PrePayPnltyTrlr_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "PrePayPnltyTrlr");
    private final static QName _Description_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "Description");
    private final static QName _NAICSCode_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "NAICSCode");
    private final static QName _OrigLoanTerm_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "OrigLoanTerm");
    private final static QName _PayoffEffDate_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "PayoffEffDate");
    private final static QName _ATMApplCode_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "ATMApplCode");
    private final static QName _PerDiemInt_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "PerDiemInt");
    private final static QName _LastOrderDate_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "LastOrderDate");
    private final static QName _PYTDTaxPd_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "PYTDTaxPd");
    private final static QName _CurrCommitAmt_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "CurrCommitAmt");
    private final static QName _LastUsed_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "LastUsed");
    private final static QName _LineInvType_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "LineInvType");
    private final static QName _MailCode_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "MailCode");
    private final static QName _OrigBranch_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "OrigBranch");
    private final static QName _LastPmtUnap_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "LastPmtUnap");
    private final static QName _StmtCombCode_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "StmtCombCode");
    private final static QName _ControlledBal_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "ControlledBal");
    private final static QName _UnusedAmt_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "UnusedAmt");
    private final static QName _LastDisbDate_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "LastDisbDate");
    private final static QName _UncollLateChrgDue_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "UncollLateChrgDue");
    private final static QName _UnappliedBal_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "UnappliedBal");
    private final static QName _CardClass_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "CardClass");
    private final static QName _NumCreditTran_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "NumCreditTran");
    private final static QName _TransferDonorFlag_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "TransferDonorFlag");
    private final static QName _EmployeeCode_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "EmployeeCode");
    private final static QName _PlacedDt_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "PlacedDt");
    private final static QName _DLState_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "DLState");
    private final static QName _MiscCharge_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "MiscCharge");
    private final static QName _HomePhone_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "HomePhone");
    private final static QName _BillIntDue_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "BillIntDue");
    private final static QName _PurgeHash_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "PurgeHash");
    private final static QName _ATMODPostDate_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "ATMODPostDate");
    private final static QName _TranTypeOpt_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "TranTypeOpt");
    private final static QName _PropInsDueDt_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "PropInsDueDt");
    private final static QName _OtherCharge_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "OtherCharge");
    private final static QName _WDAmt2_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "WDAmt2");
    private final static QName _WDAmt1_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "WDAmt1");
    private final static QName _WDAmt4_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "WDAmt4");
    private final static QName _WDAmt3_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "WDAmt3");
    private final static QName _WDAmt5_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "WDAmt5");
    private final static QName _IntAccrual_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "IntAccrual");
    private final static QName _RetirementFlag_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "RetirementFlag");
    private final static QName _PreauthOrDebitHld_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "PreauthOrDebitHld");
    private final static QName _BusNoSol_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "BusNoSol");
    private final static QName _PostDtLastPmt_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "PostDtLastPmt");
    private final static QName _StartDate_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "StartDate");
    private final static QName _PrevMaturityDate_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "PrevMaturityDate");
    private final static QName _OrigDt_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "OrigDt");
    private final static QName _RetSeqInd_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "RetSeqInd");
    private final static QName _APYECalc_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "APYECalc");
    private final static QName _NameSuffix_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "NameSuffix");
    private final static QName _MailOrder_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "MailOrder");
    private final static QName _UserDefDate_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "UserDefDate");
    private final static QName _LastATMCard_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "LastATMCard");
    private final static QName _AmountDue_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "AmountDue");
    private final static QName _OrderAmt1_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "OrderAmt1");
    private final static QName _IncomeLevel_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "IncomeLevel");
    private final static QName _TicklerDate_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "TicklerDate");
    private final static QName _OrderAmt2_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "OrderAmt2");
    private final static QName _BusinessTransInd_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "BusinessTransInd");
    private final static QName _ProcessCode_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "ProcessCode");
    private final static QName _RelFlag_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "RelFlag");
    private final static QName _ReasonCode_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "ReasonCode");
    private final static QName _AcctStatus_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "AcctStatus");
    private final static QName _PhoneType_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "PhoneType");
    private final static QName _Reasoncode_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "Reasoncode");
    private final static QName _PrevStmtDate_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "PrevStmtDate");
    private final static QName _IntAccrualDate_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "IntAccrualDate");
    private final static QName _BirthDate_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "BirthDate");
    private final static QName _DateSelection_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "DateSelection");
    private final static QName _Payee_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "Payee");
    private final static QName _RetPlanNbr_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "RetPlanNbr");
    private final static QName _LineMasterNbr_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "LineMasterNbr");
    private final static QName _CreditReport_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "CreditReport");
    private final static QName _TranCode_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "TranCode");
    private final static QName _EditAction_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "EditAction");
    private final static QName _Reason_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "Reason");
    private final static QName _ContinuationFlag_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "ContinuationFlag");
    private final static QName _PurposeCode_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "PurposeCode");
    private final static QName _SWPrevYtdAmt_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "SWPrevYtdAmt");
    private final static QName _BillpayFlag_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "BillpayFlag");
    private final static QName _YTDTaxPaid_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "YTDTaxPaid");
    private final static QName _FlagHotDate_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "FlagHotDate");
    private final static QName _AcctBal_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "AcctBal");
    private final static QName _LastPmtSubTot_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "LastPmtSubTot");
    private final static QName _TotalDisb_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "TotalDisb");
    private final static QName _Email2_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "Email2");
    private final static QName _PostAdjust_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "PostAdjust");
    private final static QName _PlacedTranDate_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "PlacedTranDate");
    private final static QName _PreAuthXfers_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "PreAuthXfers");
    private final static QName _TraceNbr1_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "TraceNbr1");
    private final static QName _NbrHoldRecs_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "NbrHoldRecs");
    private final static QName _EchoData_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "EchoData");
    private final static QName _OtherFlags_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "OtherFlags");
    private final static QName _RenewalAmt_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "RenewalAmt");
    private final static QName _DLExpDate_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "DLExpDate");
    private final static QName _PlacedTime_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "PlacedTime");
    private final static QName _MaturityDate_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "MaturityDate");
    private final static QName _NumEmails_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "NumEmails");
    private final static QName _CarryoverPr_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "CarryoverPr");
    private final static QName _MinReqBal_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "MinReqBal");
    private final static QName _MiddleName_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "MiddleName");
    private final static QName _MaxHistTran_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "MaxHistTran");
    private final static QName _BillFreqCode_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "BillFreqCode");
    private final static QName _AccrIntonEscDt_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "AccrIntonEscDt");
    private final static QName _LastPmtPr_QNAME = new QName("http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", "LastPmtPr");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.codegik.poc.cohesion.miser.vbtp
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Parameters }
     * 
     */
    public Parameters createParameters() {
        return new Parameters();
    }

    /**
     * Create an instance of {@link Accounts }
     * 
     */
    public Accounts createAccounts() {
        return new Accounts();
    }

    /**
     * Create an instance of {@link Account }
     * 
     */
    public Account createAccount() {
        return new Account();
    }

    /**
     * Create an instance of {@link Hold }
     * 
     */
    public Hold createHold() {
        return new Hold();
    }

    /**
     * Create an instance of {@link EmailItem }
     * 
     */
    public EmailItem createEmailItem() {
        return new EmailItem();
    }

    /**
     * Create an instance of {@link EmailItems }
     * 
     */
    public EmailItems createEmailItems() {
        return new EmailItems();
    }

    /**
     * Create an instance of {@link Transaction }
     * 
     */
    public Transaction createTransaction() {
        return new Transaction();
    }

    /**
     * Create an instance of {@link HistoryItem }
     * 
     */
    public HistoryItem createHistoryItem() {
        return new HistoryItem();
    }

    /**
     * Create an instance of {@link History }
     * 
     */
    public History createHistory() {
        return new History();
    }

    /**
     * Create an instance of {@link Orders }
     * 
     */
    public Orders createOrders() {
        return new Orders();
    }

    /**
     * Create an instance of {@link Order }
     * 
     */
    public Order createOrder() {
        return new Order();
    }

    /**
     * Create an instance of {@link Holds }
     * 
     */
    public Holds createHolds() {
        return new Holds();
    }

    /**
     * Create an instance of {@link VBTPRequest }
     * 
     */
    public VBTPRequest createVBTPRequest() {
        return new VBTPRequest();
    }

    /**
     * Create an instance of {@link VBTPReply }
     * 
     */
    public VBTPReply createVBTPReply() {
        return new VBTPReply();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "FaxNbr")
    public JAXBElement<Integer> createFaxNbr(Integer value) {
        return new JAXBElement<Integer>(_FaxNbr_QNAME, Integer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "YTDStateHold")
    public JAXBElement<BigDecimal> createYTDStateHold(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_YTDStateHold_QNAME, BigDecimal.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "FailDate")
    public JAXBElement<String> createFailDate(String value) {
        return new JAXBElement<String>(_FailDate_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "ATMODInd")
    public JAXBElement<Integer> createATMODInd(Integer value) {
        return new JAXBElement<Integer>(_ATMODInd_QNAME, Integer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "CellNoSol")
    public JAXBElement<Integer> createCellNoSol(Integer value) {
        return new JAXBElement<Integer>(_CellNoSol_QNAME, Integer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "AvgUnusedBal")
    public JAXBElement<String> createAvgUnusedBal(String value) {
        return new JAXBElement<String>(_AvgUnusedBal_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "TotChkHoldAmt")
    public JAXBElement<BigDecimal> createTotChkHoldAmt(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_TotChkHoldAmt_QNAME, BigDecimal.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "RunningBal")
    public JAXBElement<BigDecimal> createRunningBal(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_RunningBal_QNAME, BigDecimal.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "MaxLoanLimit")
    public JAXBElement<String> createMaxLoanLimit(String value) {
        return new JAXBElement<String>(_MaxLoanLimit_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "EchoHistDate")
    public JAXBElement<String> createEchoHistDate(String value) {
        return new JAXBElement<String>(_EchoHistDate_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "AccruIntDate")
    public JAXBElement<String> createAccruIntDate(String value) {
        return new JAXBElement<String>(_AccruIntDate_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "TransferFlag")
    public JAXBElement<String> createTransferFlag(String value) {
        return new JAXBElement<String>(_TransferFlag_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "LastCalcDate")
    public JAXBElement<String> createLastCalcDate(String value) {
        return new JAXBElement<String>(_LastCalcDate_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "CMBAccess")
    public JAXBElement<Integer> createCMBAccess(Integer value) {
        return new JAXBElement<Integer>(_CMBAccess_QNAME, Integer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "TotalCreditAmt")
    public JAXBElement<BigDecimal> createTotalCreditAmt(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_TotalCreditAmt_QNAME, BigDecimal.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "IntMethodFlag")
    public JAXBElement<Integer> createIntMethodFlag(Integer value) {
        return new JAXBElement<Integer>(_IntMethodFlag_QNAME, Integer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "FindRelCode")
    public JAXBElement<String> createFindRelCode(String value) {
        return new JAXBElement<String>(_FindRelCode_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "NameAddrLine1")
    public JAXBElement<String> createNameAddrLine1(String value) {
        return new JAXBElement<String>(_NameAddrLine1_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "HoldAmt")
    public JAXBElement<BigDecimal> createHoldAmt(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_HoldAmt_QNAME, BigDecimal.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "AvailIntAmt")
    public JAXBElement<BigDecimal> createAvailIntAmt(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_AvailIntAmt_QNAME, BigDecimal.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "NameAddrLine3")
    public JAXBElement<String> createNameAddrLine3(String value) {
        return new JAXBElement<String>(_NameAddrLine3_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "NameAddrLine2")
    public JAXBElement<String> createNameAddrLine2(String value) {
        return new JAXBElement<String>(_NameAddrLine2_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "CheckNbrorAmt")
    public JAXBElement<String> createCheckNbrorAmt(String value) {
        return new JAXBElement<String>(_CheckNbrorAmt_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "CIBAccess")
    public JAXBElement<Integer> createCIBAccess(Integer value) {
        return new JAXBElement<Integer>(_CIBAccess_QNAME, Integer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "LastDepositDate")
    public JAXBElement<String> createLastDepositDate(String value) {
        return new JAXBElement<String>(_LastDepositDate_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "NameAddrLine5")
    public JAXBElement<String> createNameAddrLine5(String value) {
        return new JAXBElement<String>(_NameAddrLine5_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "NameAddrLine4")
    public JAXBElement<String> createNameAddrLine4(String value) {
        return new JAXBElement<String>(_NameAddrLine4_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "NextBillDate")
    public JAXBElement<String> createNextBillDate(String value) {
        return new JAXBElement<String>(_NextBillDate_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "OrigAmt")
    public JAXBElement<String> createOrigAmt(String value) {
        return new JAXBElement<String>(_OrigAmt_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "TotATMHrdHoldAmt")
    public JAXBElement<BigDecimal> createTotATMHrdHoldAmt(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_TotATMHrdHoldAmt_QNAME, BigDecimal.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "CIFAcctNbr")
    public JAXBElement<Integer> createCIFAcctNbr(Integer value) {
        return new JAXBElement<Integer>(_CIFAcctNbr_QNAME, Integer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "MinCheckAmt")
    public JAXBElement<BigDecimal> createMinCheckAmt(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_MinCheckAmt_QNAME, BigDecimal.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "FaxConsentCode")
    public JAXBElement<Integer> createFaxConsentCode(Integer value) {
        return new JAXBElement<Integer>(_FaxConsentCode_QNAME, Integer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "PayMethod")
    public JAXBElement<String> createPayMethod(String value) {
        return new JAXBElement<String>(_PayMethod_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "LastPmtIns")
    public JAXBElement<BigDecimal> createLastPmtIns(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_LastPmtIns_QNAME, BigDecimal.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "CheckNbr")
    public JAXBElement<String> createCheckNbr(String value) {
        return new JAXBElement<String>(_CheckNbr_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "IntCalcDate")
    public JAXBElement<String> createIntCalcDate(String value) {
        return new JAXBElement<String>(_IntCalcDate_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "EmailAddr")
    public JAXBElement<String> createEmailAddr(String value) {
        return new JAXBElement<String>(_EmailAddr_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "LastPmtInt")
    public JAXBElement<BigDecimal> createLastPmtInt(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_LastPmtInt_QNAME, BigDecimal.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "OpenReason")
    public JAXBElement<Integer> createOpenReason(Integer value) {
        return new JAXBElement<Integer>(_OpenReason_QNAME, Integer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "KICode")
    public JAXBElement<String> createKICode(String value) {
        return new JAXBElement<String>(_KICode_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "DescCode")
    public JAXBElement<Integer> createDescCode(Integer value) {
        return new JAXBElement<Integer>(_DescCode_QNAME, Integer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "ActionCode")
    public JAXBElement<String> createActionCode(String value) {
        return new JAXBElement<String>(_ActionCode_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "AddtlInfo")
    public JAXBElement<String> createAddtlInfo(String value) {
        return new JAXBElement<String>(_AddtlInfo_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "DeliveryAddr")
    public JAXBElement<String> createDeliveryAddr(String value) {
        return new JAXBElement<String>(_DeliveryAddr_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "AltNameAddr")
    public JAXBElement<String> createAltNameAddr(String value) {
        return new JAXBElement<String>(_AltNameAddr_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "VBRInd")
    public JAXBElement<String> createVBRInd(String value) {
        return new JAXBElement<String>(_VBRInd_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "PriorYearEscrowInt")
    public JAXBElement<BigDecimal> createPriorYearEscrowInt(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_PriorYearEscrowInt_QNAME, BigDecimal.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "OrigDate")
    public JAXBElement<String> createOrigDate(String value) {
        return new JAXBElement<String>(_OrigDate_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "PendingTrxFlag")
    public JAXBElement<Integer> createPendingTrxFlag(Integer value) {
        return new JAXBElement<Integer>(_PendingTrxFlag_QNAME, Integer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "Merchant")
    public JAXBElement<String> createMerchant(String value) {
        return new JAXBElement<String>(_Merchant_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "AddrSource")
    public JAXBElement<String> createAddrSource(String value) {
        return new JAXBElement<String>(_AddrSource_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "CustTypeCode")
    public JAXBElement<String> createCustTypeCode(String value) {
        return new JAXBElement<String>(_CustTypeCode_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "PrevYTDFeesPaid")
    public JAXBElement<String> createPrevYTDFeesPaid(String value) {
        return new JAXBElement<String>(_PrevYTDFeesPaid_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "CurrYrEarnAmt")
    public JAXBElement<BigDecimal> createCurrYrEarnAmt(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_CurrYrEarnAmt_QNAME, BigDecimal.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "TranDesc")
    public JAXBElement<String> createTranDesc(String value) {
        return new JAXBElement<String>(_TranDesc_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "CreditLimit")
    public JAXBElement<BigDecimal> createCreditLimit(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_CreditLimit_QNAME, BigDecimal.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "ContributionCode")
    public JAXBElement<String> createContributionCode(String value) {
        return new JAXBElement<String>(_ContributionCode_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "TranOptCode")
    public JAXBElement<Integer> createTranOptCode(Integer value) {
        return new JAXBElement<Integer>(_TranOptCode_QNAME, Integer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "MultipleSig")
    public JAXBElement<String> createMultipleSig(String value) {
        return new JAXBElement<String>(_MultipleSig_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "TotMgmtHoldAmt")
    public JAXBElement<BigDecimal> createTotMgmtHoldAmt(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_TotMgmtHoldAmt_QNAME, BigDecimal.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "EndDate")
    public JAXBElement<String> createEndDate(String value) {
        return new JAXBElement<String>(_EndDate_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "TranCdLastPmt")
    public JAXBElement<String> createTranCdLastPmt(String value) {
        return new JAXBElement<String>(_TranCdLastPmt_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "CustName")
    public JAXBElement<String> createCustName(String value) {
        return new JAXBElement<String>(_CustName_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "UncollAmt")
    public JAXBElement<BigDecimal> createUncollAmt(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_UncollAmt_QNAME, BigDecimal.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "DtLastPmt")
    public JAXBElement<String> createDtLastPmt(String value) {
        return new JAXBElement<String>(_DtLastPmt_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "DLNbr")
    public JAXBElement<String> createDLNbr(String value) {
        return new JAXBElement<String>(_DLNbr_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "PAN")
    public JAXBElement<String> createPAN(String value) {
        return new JAXBElement<String>(_PAN_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "PostDate")
    public JAXBElement<String> createPostDate(String value) {
        return new JAXBElement<String>(_PostDate_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "TranAcctInd")
    public JAXBElement<Integer> createTranAcctInd(Integer value) {
        return new JAXBElement<Integer>(_TranAcctInd_QNAME, Integer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "PrimeRateVar")
    public JAXBElement<String> createPrimeRateVar(String value) {
        return new JAXBElement<String>(_PrimeRateVar_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "Email")
    public JAXBElement<String> createEmail(String value) {
        return new JAXBElement<String>(_Email_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "DepositYearInd")
    public JAXBElement<String> createDepositYearInd(String value) {
        return new JAXBElement<String>(_DepositYearInd_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "APYCalc")
    public JAXBElement<BigDecimal> createAPYCalc(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_APYCalc_QNAME, BigDecimal.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "DescPart5")
    public JAXBElement<String> createDescPart5(String value) {
        return new JAXBElement<String>(_DescPart5_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "ExpireDate")
    public JAXBElement<String> createExpireDate(String value) {
        return new JAXBElement<String>(_ExpireDate_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "DescPart4")
    public JAXBElement<String> createDescPart4(String value) {
        return new JAXBElement<String>(_DescPart4_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "CheckNbr1")
    public JAXBElement<Integer> createCheckNbr1(Integer value) {
        return new JAXBElement<Integer>(_CheckNbr1_QNAME, Integer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "BusConsentCode")
    public JAXBElement<Integer> createBusConsentCode(Integer value) {
        return new JAXBElement<Integer>(_BusConsentCode_QNAME, Integer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "LastDepDate")
    public JAXBElement<String> createLastDepDate(String value) {
        return new JAXBElement<String>(_LastDepDate_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "CheckNbr2")
    public JAXBElement<Integer> createCheckNbr2(Integer value) {
        return new JAXBElement<Integer>(_CheckNbr2_QNAME, Integer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "OverlineLimit")
    public JAXBElement<BigDecimal> createOverlineLimit(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_OverlineLimit_QNAME, BigDecimal.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "TotTrans")
    public JAXBElement<Integer> createTotTrans(Integer value) {
        return new JAXBElement<Integer>(_TotTrans_QNAME, Integer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "RptCode1098")
    public JAXBElement<String> createRptCode1098(String value) {
        return new JAXBElement<String>(_RptCode1098_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "CarryoverInt")
    public JAXBElement<String> createCarryoverInt(String value) {
        return new JAXBElement<String>(_CarryoverInt_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "DescPart3")
    public JAXBElement<String> createDescPart3(String value) {
        return new JAXBElement<String>(_DescPart3_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "DescPart2")
    public JAXBElement<String> createDescPart2(String value) {
        return new JAXBElement<String>(_DescPart2_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "DescPart1")
    public JAXBElement<String> createDescPart1(String value) {
        return new JAXBElement<String>(_DescPart1_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "DBCODInd")
    public JAXBElement<Integer> createDBCODInd(Integer value) {
        return new JAXBElement<Integer>(_DBCODInd_QNAME, Integer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "UsedBal")
    public JAXBElement<BigDecimal> createUsedBal(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_UsedBal_QNAME, BigDecimal.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "TranTime")
    public JAXBElement<String> createTranTime(String value) {
        return new JAXBElement<String>(_TranTime_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "NbrDep")
    public JAXBElement<Integer> createNbrDep(Integer value) {
        return new JAXBElement<Integer>(_NbrDep_QNAME, Integer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "IntColCode")
    public JAXBElement<String> createIntColCode(String value) {
        return new JAXBElement<String>(_IntColCode_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "PriorYearTaxPaid")
    public JAXBElement<BigDecimal> createPriorYearTaxPaid(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_PriorYearTaxPaid_QNAME, BigDecimal.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "ForeignPrefixFax")
    public JAXBElement<String> createForeignPrefixFax(String value) {
        return new JAXBElement<String>(_ForeignPrefixFax_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "LastIntAmt")
    public JAXBElement<BigDecimal> createLastIntAmt(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_LastIntAmt_QNAME, BigDecimal.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "AcctTitle")
    public JAXBElement<String> createAcctTitle(String value) {
        return new JAXBElement<String>(_AcctTitle_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "SkipPayment")
    public JAXBElement<String> createSkipPayment(String value) {
        return new JAXBElement<String>(_SkipPayment_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "Term")
    public JAXBElement<Integer> createTerm(Integer value) {
        return new JAXBElement<Integer>(_Term_QNAME, Integer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "LastDisbAmt")
    public JAXBElement<BigDecimal> createLastDisbAmt(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_LastDisbAmt_QNAME, BigDecimal.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "LastIntPaidDate")
    public JAXBElement<String> createLastIntPaidDate(String value) {
        return new JAXBElement<String>(_LastIntPaidDate_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "TotalLoansAttached")
    public JAXBElement<String> createTotalLoansAttached(String value) {
        return new JAXBElement<String>(_TotalLoansAttached_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "LineOfficer")
    public JAXBElement<String> createLineOfficer(String value) {
        return new JAXBElement<String>(_LineOfficer_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "RegDLimitFlag")
    public JAXBElement<String> createRegDLimitFlag(String value) {
        return new JAXBElement<String>(_RegDLimitFlag_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "ATMAcctNbr")
    public JAXBElement<Integer> createATMAcctNbr(Integer value) {
        return new JAXBElement<Integer>(_ATMAcctNbr_QNAME, Integer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "State")
    public JAXBElement<String> createState(String value) {
        return new JAXBElement<String>(_State_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "CellConsentDt")
    public JAXBElement<String> createCellConsentDt(String value) {
        return new JAXBElement<String>(_CellConsentDt_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "PassbookStmtInd")
    public JAXBElement<String> createPassbookStmtInd(String value) {
        return new JAXBElement<String>(_PassbookStmtInd_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "LastStmtBal")
    public JAXBElement<BigDecimal> createLastStmtBal(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_LastStmtBal_QNAME, BigDecimal.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "FindCIFNbr")
    public JAXBElement<Integer> createFindCIFNbr(Integer value) {
        return new JAXBElement<Integer>(_FindCIFNbr_QNAME, Integer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "DaysPastDueDt")
    public JAXBElement<String> createDaysPastDueDt(String value) {
        return new JAXBElement<String>(_DaysPastDueDt_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "TotalOutstandingAmt")
    public JAXBElement<String> createTotalOutstandingAmt(String value) {
        return new JAXBElement<String>(_TotalOutstandingAmt_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "PendTranFlag")
    public JAXBElement<Integer> createPendTranFlag(Integer value) {
        return new JAXBElement<Integer>(_PendTranFlag_QNAME, Integer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "TranCode2")
    public JAXBElement<String> createTranCode2(String value) {
        return new JAXBElement<String>(_TranCode2_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "PriApplCode")
    public JAXBElement<String> createPriApplCode(String value) {
        return new JAXBElement<String>(_PriApplCode_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "EffDate")
    public JAXBElement<String> createEffDate(String value) {
        return new JAXBElement<String>(_EffDate_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "TranCode1")
    public JAXBElement<String> createTranCode1(String value) {
        return new JAXBElement<String>(_TranCode1_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "YTDFederalHold")
    public JAXBElement<BigDecimal> createYTDFederalHold(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_YTDFederalHold_QNAME, BigDecimal.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "FWYtdAmt")
    public JAXBElement<BigDecimal> createFWYtdAmt(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_FWYtdAmt_QNAME, BigDecimal.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "XderAppl")
    public JAXBElement<Integer> createXderAppl(Integer value) {
        return new JAXBElement<Integer>(_XderAppl_QNAME, Integer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "ApplicationCode1")
    public JAXBElement<String> createApplicationCode1(String value) {
        return new JAXBElement<String>(_ApplicationCode1_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "ApplCode2")
    public JAXBElement<Integer> createApplCode2(Integer value) {
        return new JAXBElement<Integer>(_ApplCode2_QNAME, Integer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "ApplCode1")
    public JAXBElement<Integer> createApplCode1(Integer value) {
        return new JAXBElement<Integer>(_ApplCode1_QNAME, Integer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "ReturnSeq")
    public JAXBElement<String> createReturnSeq(String value) {
        return new JAXBElement<String>(_ReturnSeq_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "UnColAmtRemain")
    public JAXBElement<BigDecimal> createUnColAmtRemain(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_UnColAmtRemain_QNAME, BigDecimal.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "LastPmtLtChg")
    public JAXBElement<BigDecimal> createLastPmtLtChg(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_LastPmtLtChg_QNAME, BigDecimal.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "TotalDisbReq")
    public JAXBElement<String> createTotalDisbReq(String value) {
        return new JAXBElement<String>(_TotalDisbReq_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "HistSeqNbr")
    public JAXBElement<Integer> createHistSeqNbr(Integer value) {
        return new JAXBElement<Integer>(_HistSeqNbr_QNAME, Integer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "PrepaidInt")
    public JAXBElement<String> createPrepaidInt(String value) {
        return new JAXBElement<String>(_PrepaidInt_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "ScreenName")
    public JAXBElement<String> createScreenName(String value) {
        return new JAXBElement<String>(_ScreenName_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "LineTypeCode")
    public JAXBElement<String> createLineTypeCode(String value) {
        return new JAXBElement<String>(_LineTypeCode_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "PrevMaturityAmt")
    public JAXBElement<BigDecimal> createPrevMaturityAmt(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_PrevMaturityAmt_QNAME, BigDecimal.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "ForeignPrefixHomePhone")
    public JAXBElement<String> createForeignPrefixHomePhone(String value) {
        return new JAXBElement<String>(_ForeignPrefixHomePhone_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "ServicerNbr2")
    public JAXBElement<String> createServicerNbr2(String value) {
        return new JAXBElement<String>(_ServicerNbr2_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "ServicerNbr1")
    public JAXBElement<String> createServicerNbr1(String value) {
        return new JAXBElement<String>(_ServicerNbr1_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "EmpCode")
    public JAXBElement<Integer> createEmpCode(Integer value) {
        return new JAXBElement<Integer>(_EmpCode_QNAME, Integer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "BusPhone")
    public JAXBElement<String> createBusPhone(String value) {
        return new JAXBElement<String>(_BusPhone_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "PrBalance")
    public JAXBElement<BigDecimal> createPrBalance(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_PrBalance_QNAME, BigDecimal.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "NoteDate")
    public JAXBElement<String> createNoteDate(String value) {
        return new JAXBElement<String>(_NoteDate_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "LineUnusedAmt")
    public JAXBElement<String> createLineUnusedAmt(String value) {
        return new JAXBElement<String>(_LineUnusedAmt_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "TranOpt")
    public JAXBElement<Integer> createTranOpt(Integer value) {
        return new JAXBElement<Integer>(_TranOpt_QNAME, Integer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "LastPmtMisc")
    public JAXBElement<BigDecimal> createLastPmtMisc(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_LastPmtMisc_QNAME, BigDecimal.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "TranHistKey")
    public JAXBElement<Integer> createTranHistKey(Integer value) {
        return new JAXBElement<Integer>(_TranHistKey_QNAME, Integer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "LateChgAmt")
    public JAXBElement<String> createLateChgAmt(String value) {
        return new JAXBElement<String>(_LateChgAmt_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "LastIntDate")
    public JAXBElement<String> createLastIntDate(String value) {
        return new JAXBElement<String>(_LastIntDate_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "PrevYTDIntPaid")
    public JAXBElement<BigDecimal> createPrevYTDIntPaid(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_PrevYTDIntPaid_QNAME, BigDecimal.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "BusConsentDt")
    public JAXBElement<String> createBusConsentDt(String value) {
        return new JAXBElement<String>(_BusConsentDt_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "TranType")
    public JAXBElement<String> createTranType(String value) {
        return new JAXBElement<String>(_TranType_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "AcctNbr")
    public JAXBElement<Long> createAcctNbr(Long value) {
        return new JAXBElement<Long>(_AcctNbr_QNAME, Long.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "TotHoldAmt")
    public JAXBElement<BigDecimal> createTotHoldAmt(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_TotHoldAmt_QNAME, BigDecimal.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "NextIntDate")
    public JAXBElement<String> createNextIntDate(String value) {
        return new JAXBElement<String>(_NextIntDate_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "ApplicationCode")
    public JAXBElement<String> createApplicationCode(String value) {
        return new JAXBElement<String>(_ApplicationCode_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "ApplCode")
    public JAXBElement<String> createApplCode(String value) {
        return new JAXBElement<String>(_ApplCode_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "OtherFlag")
    public JAXBElement<String> createOtherFlag(String value) {
        return new JAXBElement<String>(_OtherFlag_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "XferAcct")
    public JAXBElement<Integer> createXferAcct(Integer value) {
        return new JAXBElement<Integer>(_XferAcct_QNAME, Integer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "AddtlAddr")
    public JAXBElement<String> createAddtlAddr(String value) {
        return new JAXBElement<String>(_AddtlAddr_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "EmailConsentDt")
    public JAXBElement<String> createEmailConsentDt(String value) {
        return new JAXBElement<String>(_EmailConsentDt_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "HoldName")
    public JAXBElement<String> createHoldName(String value) {
        return new JAXBElement<String>(_HoldName_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "UnappliedAmt")
    public JAXBElement<BigDecimal> createUnappliedAmt(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_UnappliedAmt_QNAME, BigDecimal.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "ACHSeqNbr")
    public JAXBElement<String> createACHSeqNbr(String value) {
        return new JAXBElement<String>(_ACHSeqNbr_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "LateChgTotal")
    public JAXBElement<String> createLateChgTotal(String value) {
        return new JAXBElement<String>(_LateChgTotal_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "HistorySeqNbr")
    public JAXBElement<String> createHistorySeqNbr(String value) {
        return new JAXBElement<String>(_HistorySeqNbr_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Short }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "StmtCycleCode")
    public JAXBElement<Short> createStmtCycleCode(Short value) {
        return new JAXBElement<Short>(_StmtCycleCode_QNAME, Short.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "LastEarnPaidDate")
    public JAXBElement<String> createLastEarnPaidDate(String value) {
        return new JAXBElement<String>(_LastEarnPaidDate_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "SelectionOpt")
    public JAXBElement<Integer> createSelectionOpt(Integer value) {
        return new JAXBElement<Integer>(_SelectionOpt_QNAME, Integer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "LastBillDate")
    public JAXBElement<String> createLastBillDate(String value) {
        return new JAXBElement<String>(_LastBillDate_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "LastAcctNbr")
    public JAXBElement<Integer> createLastAcctNbr(Integer value) {
        return new JAXBElement<Integer>(_LastAcctNbr_QNAME, Integer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "AccountNbr")
    public JAXBElement<Long> createAccountNbr(Long value) {
        return new JAXBElement<Long>(_AccountNbr_QNAME, Long.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "YTDIntPaid")
    public JAXBElement<BigDecimal> createYTDIntPaid(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_YTDIntPaid_QNAME, BigDecimal.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "ClosingFee")
    public JAXBElement<String> createClosingFee(String value) {
        return new JAXBElement<String>(_ClosingFee_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "CardClassDesc")
    public JAXBElement<String> createCardClassDesc(String value) {
        return new JAXBElement<String>(_CardClassDesc_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "MaxNoteAmt")
    public JAXBElement<String> createMaxNoteAmt(String value) {
        return new JAXBElement<String>(_MaxNoteAmt_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "RMBAccess")
    public JAXBElement<Integer> createRMBAccess(Integer value) {
        return new JAXBElement<Integer>(_RMBAccess_QNAME, Integer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "Teller")
    public JAXBElement<Integer> createTeller(Integer value) {
        return new JAXBElement<Integer>(_Teller_QNAME, Integer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "MinBal")
    public JAXBElement<BigDecimal> createMinBal(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_MinBal_QNAME, BigDecimal.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "TotHoldLessCheckHoldAmt")
    public JAXBElement<BigDecimal> createTotHoldLessCheckHoldAmt(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_TotHoldLessCheckHoldAmt_QNAME, BigDecimal.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "TaxID")
    public JAXBElement<String> createTaxID(String value) {
        return new JAXBElement<String>(_TaxID_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "LocationCode")
    public JAXBElement<String> createLocationCode(String value) {
        return new JAXBElement<String>(_LocationCode_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "CellConsentCode")
    public JAXBElement<Integer> createCellConsentCode(Integer value) {
        return new JAXBElement<Integer>(_CellConsentCode_QNAME, Integer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "TotalAmt")
    public JAXBElement<String> createTotalAmt(String value) {
        return new JAXBElement<String>(_TotalAmt_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "RestrictInd")
    public JAXBElement<Integer> createRestrictInd(Integer value) {
        return new JAXBElement<Integer>(_RestrictInd_QNAME, Integer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "CancelInd")
    public JAXBElement<Integer> createCancelInd(Integer value) {
        return new JAXBElement<Integer>(_CancelInd_QNAME, Integer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "MaxOutstandingPr")
    public JAXBElement<String> createMaxOutstandingPr(String value) {
        return new JAXBElement<String>(_MaxOutstandingPr_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "WDDate2")
    public JAXBElement<String> createWDDate2(String value) {
        return new JAXBElement<String>(_WDDate2_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "WDDate1")
    public JAXBElement<String> createWDDate1(String value) {
        return new JAXBElement<String>(_WDDate1_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "WDDate4")
    public JAXBElement<String> createWDDate4(String value) {
        return new JAXBElement<String>(_WDDate4_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "WDDate3")
    public JAXBElement<String> createWDDate3(String value) {
        return new JAXBElement<String>(_WDDate3_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "ConsentCode")
    public JAXBElement<String> createConsentCode(String value) {
        return new JAXBElement<String>(_ConsentCode_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "WDDate5")
    public JAXBElement<String> createWDDate5(String value) {
        return new JAXBElement<String>(_WDDate5_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "EffDtLastPmt")
    public JAXBElement<String> createEffDtLastPmt(String value) {
        return new JAXBElement<String>(_EffDtLastPmt_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "PrivacyInd")
    public JAXBElement<String> createPrivacyInd(String value) {
        return new JAXBElement<String>(_PrivacyInd_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "LastFMDate")
    public JAXBElement<String> createLastFMDate(String value) {
        return new JAXBElement<String>(_LastFMDate_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "LastMonetaryTranDate")
    public JAXBElement<String> createLastMonetaryTranDate(String value) {
        return new JAXBElement<String>(_LastMonetaryTranDate_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "SWYtdAmt")
    public JAXBElement<BigDecimal> createSWYtdAmt(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_SWYtdAmt_QNAME, BigDecimal.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "HistIndicator")
    public JAXBElement<Integer> createHistIndicator(Integer value) {
        return new JAXBElement<Integer>(_HistIndicator_QNAME, Integer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "AcctClass")
    public JAXBElement<Integer> createAcctClass(Integer value) {
        return new JAXBElement<Integer>(_AcctClass_QNAME, Integer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Short }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "TellerNbr")
    public JAXBElement<Short> createTellerNbr(Short value) {
        return new JAXBElement<Short>(_TellerNbr_QNAME, Short.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "EscrowAmt")
    public JAXBElement<BigDecimal> createEscrowAmt(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_EscrowAmt_QNAME, BigDecimal.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "DocMethodCode")
    public JAXBElement<String> createDocMethodCode(String value) {
        return new JAXBElement<String>(_DocMethodCode_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "RemUncollAmt")
    public JAXBElement<BigDecimal> createRemUncollAmt(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_RemUncollAmt_QNAME, BigDecimal.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "LastDepositAmt")
    public JAXBElement<BigDecimal> createLastDepositAmt(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_LastDepositAmt_QNAME, BigDecimal.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "CFMCustNbr")
    public JAXBElement<Integer> createCFMCustNbr(Integer value) {
        return new JAXBElement<Integer>(_CFMCustNbr_QNAME, Integer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "CompoundedInt")
    public JAXBElement<BigDecimal> createCompoundedInt(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_CompoundedInt_QNAME, BigDecimal.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "OpeningDate")
    public JAXBElement<String> createOpeningDate(String value) {
        return new JAXBElement<String>(_OpeningDate_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "LockFlags")
    public JAXBElement<String> createLockFlags(String value) {
        return new JAXBElement<String>(_LockFlags_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "AccountNbr2")
    public JAXBElement<Long> createAccountNbr2(Long value) {
        return new JAXBElement<Long>(_AccountNbr2_QNAME, Long.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "Amount")
    public JAXBElement<BigDecimal> createAmount(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_Amount_QNAME, BigDecimal.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "AccountNbr1")
    public JAXBElement<Long> createAccountNbr1(Long value) {
        return new JAXBElement<Long>(_AccountNbr1_QNAME, Long.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "PrevMatDate")
    public JAXBElement<String> createPrevMatDate(String value) {
        return new JAXBElement<String>(_PrevMatDate_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "TaxIDType")
    public JAXBElement<Integer> createTaxIDType(Integer value) {
        return new JAXBElement<Integer>(_TaxIDType_QNAME, Integer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "MultiSigFlag")
    public JAXBElement<Integer> createMultiSigFlag(Integer value) {
        return new JAXBElement<Integer>(_MultiSigFlag_QNAME, Integer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "ForeignPrefixBusPhone")
    public JAXBElement<String> createForeignPrefixBusPhone(String value) {
        return new JAXBElement<String>(_ForeignPrefixBusPhone_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "ForeignInd")
    public JAXBElement<String> createForeignInd(String value) {
        return new JAXBElement<String>(_ForeignInd_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "WarnCode2")
    public JAXBElement<Integer> createWarnCode2(Integer value) {
        return new JAXBElement<Integer>(_WarnCode2_QNAME, Integer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "WarnCode1")
    public JAXBElement<Integer> createWarnCode1(Integer value) {
        return new JAXBElement<Integer>(_WarnCode1_QNAME, Integer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "PrimeRateCode")
    public JAXBElement<String> createPrimeRateCode(String value) {
        return new JAXBElement<String>(_PrimeRateCode_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "RetireFlag")
    public JAXBElement<Integer> createRetireFlag(Integer value) {
        return new JAXBElement<Integer>(_RetireFlag_QNAME, Integer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "EchoHistBal")
    public JAXBElement<String> createEchoHistBal(String value) {
        return new JAXBElement<String>(_EchoHistBal_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "AvailBal")
    public JAXBElement<BigDecimal> createAvailBal(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_AvailBal_QNAME, BigDecimal.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "MinDrawAmt")
    public JAXBElement<BigDecimal> createMinDrawAmt(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_MinDrawAmt_QNAME, BigDecimal.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "ToDate")
    public JAXBElement<String> createToDate(String value) {
        return new JAXBElement<String>(_ToDate_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "StmtCombAcct")
    public JAXBElement<Integer> createStmtCombAcct(Integer value) {
        return new JAXBElement<Integer>(_StmtCombAcct_QNAME, Integer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "LastActivityDate")
    public JAXBElement<String> createLastActivityDate(String value) {
        return new JAXBElement<String>(_LastActivityDate_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "LastBillDt")
    public JAXBElement<String> createLastBillDt(String value) {
        return new JAXBElement<String>(_LastBillDt_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "PrimeRateVarCode")
    public JAXBElement<String> createPrimeRateVarCode(String value) {
        return new JAXBElement<String>(_PrimeRateVarCode_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "TransferReceiptFlag")
    public JAXBElement<String> createTransferReceiptFlag(String value) {
        return new JAXBElement<String>(_TransferReceiptFlag_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "TranDate")
    public JAXBElement<String> createTranDate(String value) {
        return new JAXBElement<String>(_TranDate_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "LateDays")
    public JAXBElement<Integer> createLateDays(Integer value) {
        return new JAXBElement<Integer>(_LateDays_QNAME, Integer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "DateOpen")
    public JAXBElement<String> createDateOpen(String value) {
        return new JAXBElement<String>(_DateOpen_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "HistTranType")
    public JAXBElement<Integer> createHistTranType(Integer value) {
        return new JAXBElement<Integer>(_HistTranType_QNAME, Integer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "Result")
    public JAXBElement<String> createResult(String value) {
        return new JAXBElement<String>(_Result_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "LastDepAmt")
    public JAXBElement<BigDecimal> createLastDepAmt(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_LastDepAmt_QNAME, BigDecimal.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "RefType")
    public JAXBElement<String> createRefType(String value) {
        return new JAXBElement<String>(_RefType_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "PmtTypeFlag")
    public JAXBElement<Integer> createPmtTypeFlag(Integer value) {
        return new JAXBElement<Integer>(_PmtTypeFlag_QNAME, Integer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "CarryoverDate")
    public JAXBElement<String> createCarryoverDate(String value) {
        return new JAXBElement<String>(_CarryoverDate_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "DisbAmt")
    public JAXBElement<String> createDisbAmt(String value) {
        return new JAXBElement<String>(_DisbAmt_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "XferFlag")
    public JAXBElement<Integer> createXferFlag(Integer value) {
        return new JAXBElement<Integer>(_XferFlag_QNAME, Integer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "PropTaxDueDt")
    public JAXBElement<String> createPropTaxDueDt(String value) {
        return new JAXBElement<String>(_PropTaxDueDt_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "HoldType")
    public JAXBElement<Integer> createHoldType(Integer value) {
        return new JAXBElement<Integer>(_HoldType_QNAME, Integer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "YTDAvgBal")
    public JAXBElement<String> createYTDAvgBal(String value) {
        return new JAXBElement<String>(_YTDAvgBal_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "City")
    public JAXBElement<String> createCity(String value) {
        return new JAXBElement<String>(_City_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "StmtFlag")
    public JAXBElement<Integer> createStmtFlag(Integer value) {
        return new JAXBElement<Integer>(_StmtFlag_QNAME, Integer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "LostInd")
    public JAXBElement<Integer> createLostInd(Integer value) {
        return new JAXBElement<Integer>(_LostInd_QNAME, Integer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "NumAccounts")
    public JAXBElement<Integer> createNumAccounts(Integer value) {
        return new JAXBElement<Integer>(_NumAccounts_QNAME, Integer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "TotalDebitAmt")
    public JAXBElement<BigDecimal> createTotalDebitAmt(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_TotalDebitAmt_QNAME, BigDecimal.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "InfoAttn")
    public JAXBElement<String> createInfoAttn(String value) {
        return new JAXBElement<String>(_InfoAttn_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "OpeningAmt")
    public JAXBElement<BigDecimal> createOpeningAmt(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_OpeningAmt_QNAME, BigDecimal.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "PYTDIntPaid")
    public JAXBElement<BigDecimal> createPYTDIntPaid(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_PYTDIntPaid_QNAME, BigDecimal.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "RenewalDt")
    public JAXBElement<String> createRenewalDt(String value) {
        return new JAXBElement<String>(_RenewalDt_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "LateCharge")
    public JAXBElement<BigDecimal> createLateCharge(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_LateCharge_QNAME, BigDecimal.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "InsCharge")
    public JAXBElement<BigDecimal> createInsCharge(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_InsCharge_QNAME, BigDecimal.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "AcctDesc")
    public JAXBElement<String> createAcctDesc(String value) {
        return new JAXBElement<String>(_AcctDesc_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "CardType")
    public JAXBElement<Integer> createCardType(Integer value) {
        return new JAXBElement<Integer>(_CardType_QNAME, Integer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "TicklerCode")
    public JAXBElement<String> createTicklerCode(String value) {
        return new JAXBElement<String>(_TicklerCode_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "FailCount")
    public JAXBElement<Integer> createFailCount(Integer value) {
        return new JAXBElement<Integer>(_FailCount_QNAME, Integer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "PmtTypeFlag2")
    public JAXBElement<Integer> createPmtTypeFlag2(Integer value) {
        return new JAXBElement<Integer>(_PmtTypeFlag2_QNAME, Integer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "DueDate")
    public JAXBElement<String> createDueDate(String value) {
        return new JAXBElement<String>(_DueDate_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "PayoffAmt")
    public JAXBElement<BigDecimal> createPayoffAmt(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_PayoffAmt_QNAME, BigDecimal.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "CountryCode")
    public JAXBElement<String> createCountryCode(String value) {
        return new JAXBElement<String>(_CountryCode_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "DirectDepositFlag")
    public JAXBElement<String> createDirectDepositFlag(String value) {
        return new JAXBElement<String>(_DirectDepositFlag_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "ReviewFreqCode")
    public JAXBElement<String> createReviewFreqCode(String value) {
        return new JAXBElement<String>(_ReviewFreqCode_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "TranAmt")
    public JAXBElement<BigDecimal> createTranAmt(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_TranAmt_QNAME, BigDecimal.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "NamePrefix")
    public JAXBElement<String> createNamePrefix(String value) {
        return new JAXBElement<String>(_NamePrefix_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "WDLimitFlag")
    public JAXBElement<Integer> createWDLimitFlag(Integer value) {
        return new JAXBElement<Integer>(_WDLimitFlag_QNAME, Integer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "PendVBTPTransferFlag")
    public JAXBElement<String> createPendVBTPTransferFlag(String value) {
        return new JAXBElement<String>(_PendVBTPTransferFlag_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "ProdCode")
    public JAXBElement<Integer> createProdCode(Integer value) {
        return new JAXBElement<Integer>(_ProdCode_QNAME, Integer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "Error")
    public JAXBElement<String> createError(String value) {
        return new JAXBElement<String>(_Error_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "NbrChksCleared")
    public JAXBElement<Integer> createNbrChksCleared(Integer value) {
        return new JAXBElement<Integer>(_NbrChksCleared_QNAME, Integer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "PYTDIntPd")
    public JAXBElement<BigDecimal> createPYTDIntPd(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_PYTDIntPd_QNAME, BigDecimal.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "DBCODConfirmDate")
    public JAXBElement<String> createDBCODConfirmDate(String value) {
        return new JAXBElement<String>(_DBCODConfirmDate_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "PostingDate")
    public JAXBElement<String> createPostingDate(String value) {
        return new JAXBElement<String>(_PostingDate_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "MinDrawAmt2")
    public JAXBElement<Integer> createMinDrawAmt2(Integer value) {
        return new JAXBElement<Integer>(_MinDrawAmt2_QNAME, Integer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "PrevYearYTDInt")
    public JAXBElement<BigDecimal> createPrevYearYTDInt(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_PrevYearYTDInt_QNAME, BigDecimal.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "AnnualIncome")
    public JAXBElement<String> createAnnualIncome(String value) {
        return new JAXBElement<String>(_AnnualIncome_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "EffectiveDate")
    public JAXBElement<String> createEffectiveDate(String value) {
        return new JAXBElement<String>(_EffectiveDate_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "PropType")
    public JAXBElement<String> createPropType(String value) {
        return new JAXBElement<String>(_PropType_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "IntCalcCode")
    public JAXBElement<String> createIntCalcCode(String value) {
        return new JAXBElement<String>(_IntCalcCode_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "PANType")
    public JAXBElement<String> createPANType(String value) {
        return new JAXBElement<String>(_PANType_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "CIFNbr")
    public JAXBElement<Integer> createCIFNbr(Integer value) {
        return new JAXBElement<Integer>(_CIFNbr_QNAME, Integer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "LastCIFNbr")
    public JAXBElement<Integer> createLastCIFNbr(Integer value) {
        return new JAXBElement<Integer>(_LastCIFNbr_QNAME, Integer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "BufferStartBal")
    public JAXBElement<String> createBufferStartBal(String value) {
        return new JAXBElement<String>(_BufferStartBal_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "AccrIntonEsc")
    public JAXBElement<BigDecimal> createAccrIntonEsc(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_AccrIntonEsc_QNAME, BigDecimal.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "PrBal")
    public JAXBElement<BigDecimal> createPrBal(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_PrBal_QNAME, BigDecimal.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "NumHistTran")
    public JAXBElement<Integer> createNumHistTran(Integer value) {
        return new JAXBElement<Integer>(_NumHistTran_QNAME, Integer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "ReleaseDt")
    public JAXBElement<String> createReleaseDt(String value) {
        return new JAXBElement<String>(_ReleaseDt_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "Comment1")
    public JAXBElement<String> createComment1(String value) {
        return new JAXBElement<String>(_Comment1_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "Comment2")
    public JAXBElement<String> createComment2(String value) {
        return new JAXBElement<String>(_Comment2_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "FundsType")
    public JAXBElement<Integer> createFundsType(Integer value) {
        return new JAXBElement<Integer>(_FundsType_QNAME, Integer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "OwnerCIFNbr")
    public JAXBElement<Integer> createOwnerCIFNbr(Integer value) {
        return new JAXBElement<Integer>(_OwnerCIFNbr_QNAME, Integer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "PrevYrEarnAmt")
    public JAXBElement<BigDecimal> createPrevYrEarnAmt(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_PrevYrEarnAmt_QNAME, BigDecimal.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "LineInvPct")
    public JAXBElement<String> createLineInvPct(String value) {
        return new JAXBElement<String>(_LineInvPct_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "PinOffset")
    public JAXBElement<Integer> createPinOffset(Integer value) {
        return new JAXBElement<Integer>(_PinOffset_QNAME, Integer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "RelCode")
    public JAXBElement<String> createRelCode(String value) {
        return new JAXBElement<String>(_RelCode_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "YTDIntPd")
    public JAXBElement<BigDecimal> createYTDIntPd(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_YTDIntPd_QNAME, BigDecimal.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "EmbossName2")
    public JAXBElement<String> createEmbossName2(String value) {
        return new JAXBElement<String>(_EmbossName2_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "EmbossName1")
    public JAXBElement<String> createEmbossName1(String value) {
        return new JAXBElement<String>(_EmbossName1_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "NextBillDt")
    public JAXBElement<String> createNextBillDt(String value) {
        return new JAXBElement<String>(_NextBillDt_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "RegPlanFlag")
    public JAXBElement<String> createRegPlanFlag(String value) {
        return new JAXBElement<String>(_RegPlanFlag_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "DeceasedDt")
    public JAXBElement<String> createDeceasedDt(String value) {
        return new JAXBElement<String>(_DeceasedDt_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "NbrTrans")
    public JAXBElement<Integer> createNbrTrans(Integer value) {
        return new JAXBElement<Integer>(_NbrTrans_QNAME, Integer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "OwnRentInd")
    public JAXBElement<String> createOwnRentInd(String value) {
        return new JAXBElement<String>(_OwnRentInd_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "MaxHistReply")
    public JAXBElement<String> createMaxHistReply(String value) {
        return new JAXBElement<String>(_MaxHistReply_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "LastPmtDate")
    public JAXBElement<String> createLastPmtDate(String value) {
        return new JAXBElement<String>(_LastPmtDate_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "TotCollatHoldAmt")
    public JAXBElement<String> createTotCollatHoldAmt(String value) {
        return new JAXBElement<String>(_TotCollatHoldAmt_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "YTDInt")
    public JAXBElement<BigDecimal> createYTDInt(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_YTDInt_QNAME, BigDecimal.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "FWPrevYtdAmt")
    public JAXBElement<BigDecimal> createFWPrevYtdAmt(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_FWPrevYtdAmt_QNAME, BigDecimal.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "LastPmtOther")
    public JAXBElement<BigDecimal> createLastPmtOther(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_LastPmtOther_QNAME, BigDecimal.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "AccruInt")
    public JAXBElement<String> createAccruInt(String value) {
        return new JAXBElement<String>(_AccruInt_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "NameAddrCode5")
    public JAXBElement<Integer> createNameAddrCode5(Integer value) {
        return new JAXBElement<Integer>(_NameAddrCode5_QNAME, Integer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "StatementDate")
    public JAXBElement<String> createStatementDate(String value) {
        return new JAXBElement<String>(_StatementDate_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "TraceNbr")
    public JAXBElement<String> createTraceNbr(String value) {
        return new JAXBElement<String>(_TraceNbr_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "WarnFlag")
    public JAXBElement<Integer> createWarnFlag(Integer value) {
        return new JAXBElement<Integer>(_WarnFlag_QNAME, Integer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "NameAddrCode1")
    public JAXBElement<Integer> createNameAddrCode1(Integer value) {
        return new JAXBElement<Integer>(_NameAddrCode1_QNAME, Integer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "NameAddrCode2")
    public JAXBElement<Integer> createNameAddrCode2(Integer value) {
        return new JAXBElement<Integer>(_NameAddrCode2_QNAME, Integer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "CollectionsFlag")
    public JAXBElement<String> createCollectionsFlag(String value) {
        return new JAXBElement<String>(_CollectionsFlag_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "NameAddrCode3")
    public JAXBElement<Integer> createNameAddrCode3(Integer value) {
        return new JAXBElement<Integer>(_NameAddrCode3_QNAME, Integer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "NameAddrCode4")
    public JAXBElement<Integer> createNameAddrCode4(Integer value) {
        return new JAXBElement<Integer>(_NameAddrCode4_QNAME, Integer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "IntMethod")
    public JAXBElement<Integer> createIntMethod(Integer value) {
        return new JAXBElement<Integer>(_IntMethod_QNAME, Integer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "LastStmtDate")
    public JAXBElement<String> createLastStmtDate(String value) {
        return new JAXBElement<String>(_LastStmtDate_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "CFMCustNbrType")
    public JAXBElement<Integer> createCFMCustNbrType(Integer value) {
        return new JAXBElement<Integer>(_CFMCustNbrType_QNAME, Integer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "ExpDate")
    public JAXBElement<String> createExpDate(String value) {
        return new JAXBElement<String>(_ExpDate_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "LedgerBal")
    public JAXBElement<BigDecimal> createLedgerBal(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_LedgerBal_QNAME, BigDecimal.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "RetItemFee")
    public JAXBElement<BigDecimal> createRetItemFee(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_RetItemFee_QNAME, BigDecimal.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "ReasonCode1")
    public JAXBElement<String> createReasonCode1(String value) {
        return new JAXBElement<String>(_ReasonCode1_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "OrderNbr")
    public JAXBElement<Integer> createOrderNbr(Integer value) {
        return new JAXBElement<Integer>(_OrderNbr_QNAME, Integer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "ReasonCode2")
    public JAXBElement<String> createReasonCode2(String value) {
        return new JAXBElement<String>(_ReasonCode2_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "WarnFlags")
    public JAXBElement<String> createWarnFlags(String value) {
        return new JAXBElement<String>(_WarnFlags_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "YTDTaxPd")
    public JAXBElement<BigDecimal> createYTDTaxPd(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_YTDTaxPd_QNAME, BigDecimal.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "StatusInd")
    public JAXBElement<String> createStatusInd(String value) {
        return new JAXBElement<String>(_StatusInd_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "SelectionInd")
    public JAXBElement<String> createSelectionInd(String value) {
        return new JAXBElement<String>(_SelectionInd_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "FirstName")
    public JAXBElement<String> createFirstName(String value) {
        return new JAXBElement<String>(_FirstName_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "LastEarnPaidAmt")
    public JAXBElement<BigDecimal> createLastEarnPaidAmt(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_LastEarnPaidAmt_QNAME, BigDecimal.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "PrevYTDTaxes")
    public JAXBElement<BigDecimal> createPrevYTDTaxes(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_PrevYTDTaxes_QNAME, BigDecimal.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "LastPmtAmt")
    public JAXBElement<BigDecimal> createLastPmtAmt(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_LastPmtAmt_QNAME, BigDecimal.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "EvalAcctStatus")
    public JAXBElement<Integer> createEvalAcctStatus(Integer value) {
        return new JAXBElement<Integer>(_EvalAcctStatus_QNAME, Integer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "EmpFlag")
    public JAXBElement<Integer> createEmpFlag(Integer value) {
        return new JAXBElement<Integer>(_EmpFlag_QNAME, Integer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "PriAcctNbr")
    public JAXBElement<String> createPriAcctNbr(String value) {
        return new JAXBElement<String>(_PriAcctNbr_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "DueDt")
    public JAXBElement<String> createDueDt(String value) {
        return new JAXBElement<String>(_DueDt_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "EmailSeq")
    public JAXBElement<String> createEmailSeq(String value) {
        return new JAXBElement<String>(_EmailSeq_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "EffHistDate")
    public JAXBElement<String> createEffHistDate(String value) {
        return new JAXBElement<String>(_EffHistDate_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "HistSeqInd")
    public JAXBElement<Integer> createHistSeqInd(Integer value) {
        return new JAXBElement<Integer>(_HistSeqInd_QNAME, Integer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "LastIntPaidAmt")
    public JAXBElement<BigDecimal> createLastIntPaidAmt(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_LastIntPaidAmt_QNAME, BigDecimal.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "ATMODConfirmDate")
    public JAXBElement<String> createATMODConfirmDate(String value) {
        return new JAXBElement<String>(_ATMODConfirmDate_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "PhoneExt")
    public JAXBElement<String> createPhoneExt(String value) {
        return new JAXBElement<String>(_PhoneExt_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "UnColAmt1Day")
    public JAXBElement<BigDecimal> createUnColAmt1Day(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_UnColAmt1Day_QNAME, BigDecimal.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "BusPhoneExt")
    public JAXBElement<String> createBusPhoneExt(String value) {
        return new JAXBElement<String>(_BusPhoneExt_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "ContactType")
    public JAXBElement<String> createContactType(String value) {
        return new JAXBElement<String>(_ContactType_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "YTDIntPenalty")
    public JAXBElement<BigDecimal> createYTDIntPenalty(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_YTDIntPenalty_QNAME, BigDecimal.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "ReviewDate")
    public JAXBElement<String> createReviewDate(String value) {
        return new JAXBElement<String>(_ReviewDate_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "PlacedDate")
    public JAXBElement<String> createPlacedDate(String value) {
        return new JAXBElement<String>(_PlacedDate_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "RptFlag1098")
    public JAXBElement<String> createRptFlag1098(String value) {
        return new JAXBElement<String>(_RptFlag1098_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "TranSource")
    public JAXBElement<String> createTranSource(String value) {
        return new JAXBElement<String>(_TranSource_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "TranCountRegD")
    public JAXBElement<Integer> createTranCountRegD(Integer value) {
        return new JAXBElement<Integer>(_TranCountRegD_QNAME, Integer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "PrevYearYTDIntPenalty")
    public JAXBElement<BigDecimal> createPrevYearYTDIntPenalty(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_PrevYearYTDIntPenalty_QNAME, BigDecimal.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "CIFNameLine1")
    public JAXBElement<String> createCIFNameLine1(String value) {
        return new JAXBElement<String>(_CIFNameLine1_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "CardTypeCode")
    public JAXBElement<Integer> createCardTypeCode(Integer value) {
        return new JAXBElement<Integer>(_CardTypeCode_QNAME, Integer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "HistDate")
    public JAXBElement<String> createHistDate(String value) {
        return new JAXBElement<String>(_HistDate_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "HomeNoSol")
    public JAXBElement<Integer> createHomeNoSol(Integer value) {
        return new JAXBElement<Integer>(_HomeNoSol_QNAME, Integer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "DBCODPostDate")
    public JAXBElement<String> createDBCODPostDate(String value) {
        return new JAXBElement<String>(_DBCODPostDate_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "HistBuffers")
    public JAXBElement<Integer> createHistBuffers(Integer value) {
        return new JAXBElement<Integer>(_HistBuffers_QNAME, Integer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "IntCalcBasis")
    public JAXBElement<String> createIntCalcBasis(String value) {
        return new JAXBElement<String>(_IntCalcBasis_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "TotalOutstandingPrevAmt")
    public JAXBElement<String> createTotalOutstandingPrevAmt(String value) {
        return new JAXBElement<String>(_TotalOutstandingPrevAmt_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "LoanAcctNbrLink")
    public JAXBElement<String> createLoanAcctNbrLink(String value) {
        return new JAXBElement<String>(_LoanAcctNbrLink_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "ServicerNumber1")
    public JAXBElement<String> createServicerNumber1(String value) {
        return new JAXBElement<String>(_ServicerNumber1_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "PhoneNbr")
    public JAXBElement<String> createPhoneNbr(String value) {
        return new JAXBElement<String>(_PhoneNbr_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "DenialCode")
    public JAXBElement<Integer> createDenialCode(Integer value) {
        return new JAXBElement<Integer>(_DenialCode_QNAME, Integer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "AcctType")
    public JAXBElement<Integer> createAcctType(Integer value) {
        return new JAXBElement<Integer>(_AcctType_QNAME, Integer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "AudioAccess")
    public JAXBElement<Integer> createAudioAccess(Integer value) {
        return new JAXBElement<Integer>(_AudioAccess_QNAME, Integer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "LastStmtDt")
    public JAXBElement<String> createLastStmtDt(String value) {
        return new JAXBElement<String>(_LastStmtDt_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "DateOpened")
    public JAXBElement<String> createDateOpened(String value) {
        return new JAXBElement<String>(_DateOpened_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "HomeConsentCode")
    public JAXBElement<Integer> createHomeConsentCode(Integer value) {
        return new JAXBElement<Integer>(_HomeConsentCode_QNAME, Integer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "IntRate")
    public JAXBElement<BigDecimal> createIntRate(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_IntRate_QNAME, BigDecimal.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "HouseholdNbr")
    public JAXBElement<Integer> createHouseholdNbr(Integer value) {
        return new JAXBElement<Integer>(_HouseholdNbr_QNAME, Integer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "LastApplCode")
    public JAXBElement<Integer> createLastApplCode(Integer value) {
        return new JAXBElement<Integer>(_LastApplCode_QNAME, Integer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "OtherAmt")
    public JAXBElement<BigDecimal> createOtherAmt(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_OtherAmt_QNAME, BigDecimal.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "ForeignPrefixCellPhone")
    public JAXBElement<String> createForeignPrefixCellPhone(String value) {
        return new JAXBElement<String>(_ForeignPrefixCellPhone_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "TaxType")
    public JAXBElement<String> createTaxType(String value) {
        return new JAXBElement<String>(_TaxType_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "UserNbr6")
    public JAXBElement<Integer> createUserNbr6(Integer value) {
        return new JAXBElement<Integer>(_UserNbr6_QNAME, Integer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "UserNbr5")
    public JAXBElement<Integer> createUserNbr5(Integer value) {
        return new JAXBElement<Integer>(_UserNbr5_QNAME, Integer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "UserNbr4")
    public JAXBElement<Integer> createUserNbr4(Integer value) {
        return new JAXBElement<Integer>(_UserNbr4_QNAME, Integer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "UserNbr3")
    public JAXBElement<Integer> createUserNbr3(Integer value) {
        return new JAXBElement<Integer>(_UserNbr3_QNAME, Integer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "SubAcctType")
    public JAXBElement<String> createSubAcctType(String value) {
        return new JAXBElement<String>(_SubAcctType_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "LastName")
    public JAXBElement<String> createLastName(String value) {
        return new JAXBElement<String>(_LastName_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "HomeConsentDt")
    public JAXBElement<String> createHomeConsentDt(String value) {
        return new JAXBElement<String>(_HomeConsentDt_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "NumDebitTran")
    public JAXBElement<Integer> createNumDebitTran(Integer value) {
        return new JAXBElement<Integer>(_NumDebitTran_QNAME, Integer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "CollFlag")
    public JAXBElement<String> createCollFlag(String value) {
        return new JAXBElement<String>(_CollFlag_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "GraceCode")
    public JAXBElement<String> createGraceCode(String value) {
        return new JAXBElement<String>(_GraceCode_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "MaidenName")
    public JAXBElement<String> createMaidenName(String value) {
        return new JAXBElement<String>(_MaidenName_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "ReviewFlag")
    public JAXBElement<String> createReviewFlag(String value) {
        return new JAXBElement<String>(_ReviewFlag_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "YTDFeesPaid")
    public JAXBElement<String> createYTDFeesPaid(String value) {
        return new JAXBElement<String>(_YTDFeesPaid_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "PrevYTDIntPenalty")
    public JAXBElement<BigDecimal> createPrevYTDIntPenalty(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_PrevYTDIntPenalty_QNAME, BigDecimal.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "OrigCommitAmt")
    public JAXBElement<BigDecimal> createOrigCommitAmt(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_OrigCommitAmt_QNAME, BigDecimal.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "UserNbr2")
    public JAXBElement<Integer> createUserNbr2(Integer value) {
        return new JAXBElement<Integer>(_UserNbr2_QNAME, Integer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "UserNbr1")
    public JAXBElement<Integer> createUserNbr1(Integer value) {
        return new JAXBElement<Integer>(_UserNbr1_QNAME, Integer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "CellPhone")
    public JAXBElement<String> createCellPhone(String value) {
        return new JAXBElement<String>(_CellPhone_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "EmailConsentCode")
    public JAXBElement<String> createEmailConsentCode(String value) {
        return new JAXBElement<String>(_EmailConsentCode_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "TranPAN")
    public JAXBElement<String> createTranPAN(String value) {
        return new JAXBElement<String>(_TranPAN_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "LangPref")
    public JAXBElement<String> createLangPref(String value) {
        return new JAXBElement<String>(_LangPref_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "LastTranBranch")
    public JAXBElement<String> createLastTranBranch(String value) {
        return new JAXBElement<String>(_LastTranBranch_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "StmtCombAppl")
    public JAXBElement<Integer> createStmtCombAppl(Integer value) {
        return new JAXBElement<Integer>(_StmtCombAppl_QNAME, Integer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "Branch")
    public JAXBElement<Integer> createBranch(Integer value) {
        return new JAXBElement<Integer>(_Branch_QNAME, Integer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "PrincipalAmt")
    public JAXBElement<BigDecimal> createPrincipalAmt(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_PrincipalAmt_QNAME, BigDecimal.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "LastPmtEsc")
    public JAXBElement<BigDecimal> createLastPmtEsc(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_LastPmtEsc_QNAME, BigDecimal.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "ZipCode")
    public JAXBElement<String> createZipCode(String value) {
        return new JAXBElement<String>(_ZipCode_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "PANLength")
    public JAXBElement<Integer> createPANLength(Integer value) {
        return new JAXBElement<Integer>(_PANLength_QNAME, Integer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "CustBal")
    public JAXBElement<String> createCustBal(String value) {
        return new JAXBElement<String>(_CustBal_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "StateCode")
    public JAXBElement<String> createStateCode(String value) {
        return new JAXBElement<String>(_StateCode_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "FaxConsentDt")
    public JAXBElement<String> createFaxConsentDt(String value) {
        return new JAXBElement<String>(_FaxConsentDt_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "OrigLnAmt")
    public JAXBElement<BigDecimal> createOrigLnAmt(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_OrigLnAmt_QNAME, BigDecimal.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "MthlyPmtAmt")
    public JAXBElement<BigDecimal> createMthlyPmtAmt(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_MthlyPmtAmt_QNAME, BigDecimal.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "LockFlag")
    public JAXBElement<Integer> createLockFlag(Integer value) {
        return new JAXBElement<Integer>(_LockFlag_QNAME, Integer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "ReceiptNbr")
    public JAXBElement<String> createReceiptNbr(String value) {
        return new JAXBElement<String>(_ReceiptNbr_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "StolenInd")
    public JAXBElement<Integer> createStolenInd(Integer value) {
        return new JAXBElement<Integer>(_StolenInd_QNAME, Integer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "FaxNoSol")
    public JAXBElement<Integer> createFaxNoSol(Integer value) {
        return new JAXBElement<Integer>(_FaxNoSol_QNAME, Integer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "DVAdjust")
    public JAXBElement<Integer> createDVAdjust(Integer value) {
        return new JAXBElement<Integer>(_DVAdjust_QNAME, Integer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "ServicerAccountNumber2")
    public JAXBElement<String> createServicerAccountNumber2(String value) {
        return new JAXBElement<String>(_ServicerAccountNumber2_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "ServicerAccountNumber1")
    public JAXBElement<String> createServicerAccountNumber1(String value) {
        return new JAXBElement<String>(_ServicerAccountNumber1_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "GraceDays")
    public JAXBElement<Integer> createGraceDays(Integer value) {
        return new JAXBElement<Integer>(_GraceDays_QNAME, Integer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "CarryoverEsc")
    public JAXBElement<String> createCarryoverEsc(String value) {
        return new JAXBElement<String>(_CarryoverEsc_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "NoSolInd")
    public JAXBElement<String> createNoSolInd(String value) {
        return new JAXBElement<String>(_NoSolInd_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "InterestAmt")
    public JAXBElement<BigDecimal> createInterestAmt(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_InterestAmt_QNAME, BigDecimal.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "LastPmtEscInt")
    public JAXBElement<BigDecimal> createLastPmtEscInt(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_LastPmtEscInt_QNAME, BigDecimal.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "IntlPrefix")
    public JAXBElement<String> createIntlPrefix(String value) {
        return new JAXBElement<String>(_IntlPrefix_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "EscrowBal")
    public JAXBElement<BigDecimal> createEscrowBal(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_EscrowBal_QNAME, BigDecimal.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "NonBalAmt")
    public JAXBElement<BigDecimal> createNonBalAmt(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_NonBalAmt_QNAME, BigDecimal.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "PayoffBal")
    public JAXBElement<BigDecimal> createPayoffBal(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_PayoffBal_QNAME, BigDecimal.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "SeqNbr")
    public JAXBElement<Integer> createSeqNbr(Integer value) {
        return new JAXBElement<Integer>(_SeqNbr_QNAME, Integer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "RIBAccess")
    public JAXBElement<Integer> createRIBAccess(Integer value) {
        return new JAXBElement<Integer>(_RIBAccess_QNAME, Integer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "PINNbr")
    public JAXBElement<Integer> createPINNbr(Integer value) {
        return new JAXBElement<Integer>(_PINNbr_QNAME, Integer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "PassbookStmtCode")
    public JAXBElement<String> createPassbookStmtCode(String value) {
        return new JAXBElement<String>(_PassbookStmtCode_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "FeePaymentDueDt")
    public JAXBElement<String> createFeePaymentDueDt(String value) {
        return new JAXBElement<String>(_FeePaymentDueDt_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "FindMailOrder")
    public JAXBElement<Integer> createFindMailOrder(Integer value) {
        return new JAXBElement<Integer>(_FindMailOrder_QNAME, Integer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "XferCode")
    public JAXBElement<Integer> createXferCode(Integer value) {
        return new JAXBElement<Integer>(_XferCode_QNAME, Integer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "TotAmtDue")
    public JAXBElement<BigDecimal> createTotAmtDue(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_TotAmtDue_QNAME, BigDecimal.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "LockCode1")
    public JAXBElement<Integer> createLockCode1(Integer value) {
        return new JAXBElement<Integer>(_LockCode1_QNAME, Integer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "UpdateMonth")
    public JAXBElement<String> createUpdateMonth(String value) {
        return new JAXBElement<String>(_UpdateMonth_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "LockCode2")
    public JAXBElement<Integer> createLockCode2(Integer value) {
        return new JAXBElement<Integer>(_LockCode2_QNAME, Integer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "YTDEscrowInt")
    public JAXBElement<BigDecimal> createYTDEscrowInt(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_YTDEscrowInt_QNAME, BigDecimal.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "ODAvailBal")
    public JAXBElement<BigDecimal> createODAvailBal(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_ODAvailBal_QNAME, BigDecimal.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "EscrowInt")
    public JAXBElement<BigDecimal> createEscrowInt(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_EscrowInt_QNAME, BigDecimal.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "LastOrderNbr")
    public JAXBElement<Integer> createLastOrderNbr(Integer value) {
        return new JAXBElement<Integer>(_LastOrderNbr_QNAME, Integer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "TermFormatCode")
    public JAXBElement<String> createTermFormatCode(String value) {
        return new JAXBElement<String>(_TermFormatCode_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "FromDate")
    public JAXBElement<String> createFromDate(String value) {
        return new JAXBElement<String>(_FromDate_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "YTDTaxes")
    public JAXBElement<BigDecimal> createYTDTaxes(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_YTDTaxes_QNAME, BigDecimal.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "Country")
    public JAXBElement<String> createCountry(String value) {
        return new JAXBElement<String>(_Country_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "PrePayPnltyTrlr")
    public JAXBElement<String> createPrePayPnltyTrlr(String value) {
        return new JAXBElement<String>(_PrePayPnltyTrlr_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "Description")
    public JAXBElement<String> createDescription(String value) {
        return new JAXBElement<String>(_Description_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "NAICSCode")
    public JAXBElement<String> createNAICSCode(String value) {
        return new JAXBElement<String>(_NAICSCode_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "OrigLoanTerm")
    public JAXBElement<String> createOrigLoanTerm(String value) {
        return new JAXBElement<String>(_OrigLoanTerm_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "PayoffEffDate")
    public JAXBElement<String> createPayoffEffDate(String value) {
        return new JAXBElement<String>(_PayoffEffDate_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "ATMApplCode")
    public JAXBElement<Integer> createATMApplCode(Integer value) {
        return new JAXBElement<Integer>(_ATMApplCode_QNAME, Integer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "PerDiemInt")
    public JAXBElement<BigDecimal> createPerDiemInt(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_PerDiemInt_QNAME, BigDecimal.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "LastOrderDate")
    public JAXBElement<String> createLastOrderDate(String value) {
        return new JAXBElement<String>(_LastOrderDate_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "PYTDTaxPd")
    public JAXBElement<BigDecimal> createPYTDTaxPd(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_PYTDTaxPd_QNAME, BigDecimal.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "CurrCommitAmt")
    public JAXBElement<BigDecimal> createCurrCommitAmt(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_CurrCommitAmt_QNAME, BigDecimal.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "LastUsed")
    public JAXBElement<Integer> createLastUsed(Integer value) {
        return new JAXBElement<Integer>(_LastUsed_QNAME, Integer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "LineInvType")
    public JAXBElement<String> createLineInvType(String value) {
        return new JAXBElement<String>(_LineInvType_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "MailCode")
    public JAXBElement<String> createMailCode(String value) {
        return new JAXBElement<String>(_MailCode_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Short }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "OrigBranch")
    public JAXBElement<Short> createOrigBranch(Short value) {
        return new JAXBElement<Short>(_OrigBranch_QNAME, Short.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "LastPmtUnap")
    public JAXBElement<BigDecimal> createLastPmtUnap(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_LastPmtUnap_QNAME, BigDecimal.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "StmtCombCode")
    public JAXBElement<Integer> createStmtCombCode(Integer value) {
        return new JAXBElement<Integer>(_StmtCombCode_QNAME, Integer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "ControlledBal")
    public JAXBElement<String> createControlledBal(String value) {
        return new JAXBElement<String>(_ControlledBal_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "UnusedAmt")
    public JAXBElement<String> createUnusedAmt(String value) {
        return new JAXBElement<String>(_UnusedAmt_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "LastDisbDate")
    public JAXBElement<String> createLastDisbDate(String value) {
        return new JAXBElement<String>(_LastDisbDate_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "UncollLateChrgDue")
    public JAXBElement<BigDecimal> createUncollLateChrgDue(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_UncollLateChrgDue_QNAME, BigDecimal.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "UnappliedBal")
    public JAXBElement<BigDecimal> createUnappliedBal(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_UnappliedBal_QNAME, BigDecimal.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "CardClass")
    public JAXBElement<Integer> createCardClass(Integer value) {
        return new JAXBElement<Integer>(_CardClass_QNAME, Integer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "NumCreditTran")
    public JAXBElement<Integer> createNumCreditTran(Integer value) {
        return new JAXBElement<Integer>(_NumCreditTran_QNAME, Integer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "TransferDonorFlag")
    public JAXBElement<String> createTransferDonorFlag(String value) {
        return new JAXBElement<String>(_TransferDonorFlag_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "EmployeeCode")
    public JAXBElement<Integer> createEmployeeCode(Integer value) {
        return new JAXBElement<Integer>(_EmployeeCode_QNAME, Integer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "PlacedDt")
    public JAXBElement<String> createPlacedDt(String value) {
        return new JAXBElement<String>(_PlacedDt_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "DLState")
    public JAXBElement<String> createDLState(String value) {
        return new JAXBElement<String>(_DLState_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "MiscCharge")
    public JAXBElement<BigDecimal> createMiscCharge(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_MiscCharge_QNAME, BigDecimal.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "HomePhone")
    public JAXBElement<String> createHomePhone(String value) {
        return new JAXBElement<String>(_HomePhone_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "BillIntDue")
    public JAXBElement<String> createBillIntDue(String value) {
        return new JAXBElement<String>(_BillIntDue_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "PurgeHash")
    public JAXBElement<String> createPurgeHash(String value) {
        return new JAXBElement<String>(_PurgeHash_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "ATMODPostDate")
    public JAXBElement<String> createATMODPostDate(String value) {
        return new JAXBElement<String>(_ATMODPostDate_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "TranTypeOpt")
    public JAXBElement<String> createTranTypeOpt(String value) {
        return new JAXBElement<String>(_TranTypeOpt_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "PropInsDueDt")
    public JAXBElement<String> createPropInsDueDt(String value) {
        return new JAXBElement<String>(_PropInsDueDt_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "OtherCharge")
    public JAXBElement<BigDecimal> createOtherCharge(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_OtherCharge_QNAME, BigDecimal.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "WDAmt2")
    public JAXBElement<BigDecimal> createWDAmt2(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_WDAmt2_QNAME, BigDecimal.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "WDAmt1")
    public JAXBElement<BigDecimal> createWDAmt1(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_WDAmt1_QNAME, BigDecimal.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "WDAmt4")
    public JAXBElement<BigDecimal> createWDAmt4(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_WDAmt4_QNAME, BigDecimal.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "WDAmt3")
    public JAXBElement<BigDecimal> createWDAmt3(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_WDAmt3_QNAME, BigDecimal.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "WDAmt5")
    public JAXBElement<BigDecimal> createWDAmt5(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_WDAmt5_QNAME, BigDecimal.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "IntAccrual")
    public JAXBElement<BigDecimal> createIntAccrual(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_IntAccrual_QNAME, BigDecimal.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "RetirementFlag")
    public JAXBElement<Integer> createRetirementFlag(Integer value) {
        return new JAXBElement<Integer>(_RetirementFlag_QNAME, Integer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "PreauthOrDebitHld")
    public JAXBElement<String> createPreauthOrDebitHld(String value) {
        return new JAXBElement<String>(_PreauthOrDebitHld_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "BusNoSol")
    public JAXBElement<Integer> createBusNoSol(Integer value) {
        return new JAXBElement<Integer>(_BusNoSol_QNAME, Integer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "PostDtLastPmt")
    public JAXBElement<String> createPostDtLastPmt(String value) {
        return new JAXBElement<String>(_PostDtLastPmt_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "StartDate")
    public JAXBElement<String> createStartDate(String value) {
        return new JAXBElement<String>(_StartDate_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "PrevMaturityDate")
    public JAXBElement<String> createPrevMaturityDate(String value) {
        return new JAXBElement<String>(_PrevMaturityDate_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "OrigDt")
    public JAXBElement<String> createOrigDt(String value) {
        return new JAXBElement<String>(_OrigDt_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "RetSeqInd")
    public JAXBElement<String> createRetSeqInd(String value) {
        return new JAXBElement<String>(_RetSeqInd_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "APYECalc")
    public JAXBElement<BigDecimal> createAPYECalc(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_APYECalc_QNAME, BigDecimal.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "NameSuffix")
    public JAXBElement<String> createNameSuffix(String value) {
        return new JAXBElement<String>(_NameSuffix_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "MailOrder")
    public JAXBElement<Integer> createMailOrder(Integer value) {
        return new JAXBElement<Integer>(_MailOrder_QNAME, Integer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "UserDefDate")
    public JAXBElement<XMLGregorianCalendar> createUserDefDate(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_UserDefDate_QNAME, XMLGregorianCalendar.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "LastATMCard")
    public JAXBElement<String> createLastATMCard(String value) {
        return new JAXBElement<String>(_LastATMCard_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "AmountDue")
    public JAXBElement<BigDecimal> createAmountDue(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_AmountDue_QNAME, BigDecimal.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "OrderAmt1")
    public JAXBElement<BigDecimal> createOrderAmt1(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_OrderAmt1_QNAME, BigDecimal.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "IncomeLevel")
    public JAXBElement<Integer> createIncomeLevel(Integer value) {
        return new JAXBElement<Integer>(_IncomeLevel_QNAME, Integer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "TicklerDate")
    public JAXBElement<String> createTicklerDate(String value) {
        return new JAXBElement<String>(_TicklerDate_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "OrderAmt2")
    public JAXBElement<BigDecimal> createOrderAmt2(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_OrderAmt2_QNAME, BigDecimal.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "BusinessTransInd")
    public JAXBElement<String> createBusinessTransInd(String value) {
        return new JAXBElement<String>(_BusinessTransInd_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "ProcessCode")
    public JAXBElement<Integer> createProcessCode(Integer value) {
        return new JAXBElement<Integer>(_ProcessCode_QNAME, Integer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "RelFlag")
    public JAXBElement<Integer> createRelFlag(Integer value) {
        return new JAXBElement<Integer>(_RelFlag_QNAME, Integer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "ReasonCode")
    public JAXBElement<Integer> createReasonCode(Integer value) {
        return new JAXBElement<Integer>(_ReasonCode_QNAME, Integer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "AcctStatus")
    public JAXBElement<String> createAcctStatus(String value) {
        return new JAXBElement<String>(_AcctStatus_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "PhoneType")
    public JAXBElement<String> createPhoneType(String value) {
        return new JAXBElement<String>(_PhoneType_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "Reasoncode")
    public JAXBElement<Integer> createReasoncode(Integer value) {
        return new JAXBElement<Integer>(_Reasoncode_QNAME, Integer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "PrevStmtDate")
    public JAXBElement<String> createPrevStmtDate(String value) {
        return new JAXBElement<String>(_PrevStmtDate_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "IntAccrualDate")
    public JAXBElement<String> createIntAccrualDate(String value) {
        return new JAXBElement<String>(_IntAccrualDate_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "BirthDate")
    public JAXBElement<String> createBirthDate(String value) {
        return new JAXBElement<String>(_BirthDate_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "DateSelection")
    public JAXBElement<String> createDateSelection(String value) {
        return new JAXBElement<String>(_DateSelection_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "Payee")
    public JAXBElement<String> createPayee(String value) {
        return new JAXBElement<String>(_Payee_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "RetPlanNbr")
    public JAXBElement<Integer> createRetPlanNbr(Integer value) {
        return new JAXBElement<Integer>(_RetPlanNbr_QNAME, Integer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "LineMasterNbr")
    public JAXBElement<String> createLineMasterNbr(String value) {
        return new JAXBElement<String>(_LineMasterNbr_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "CreditReport")
    public JAXBElement<Integer> createCreditReport(Integer value) {
        return new JAXBElement<Integer>(_CreditReport_QNAME, Integer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "TranCode")
    public JAXBElement<String> createTranCode(String value) {
        return new JAXBElement<String>(_TranCode_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "EditAction")
    public JAXBElement<String> createEditAction(String value) {
        return new JAXBElement<String>(_EditAction_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "Reason")
    public JAXBElement<String> createReason(String value) {
        return new JAXBElement<String>(_Reason_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "ContinuationFlag")
    public JAXBElement<String> createContinuationFlag(String value) {
        return new JAXBElement<String>(_ContinuationFlag_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "PurposeCode")
    public JAXBElement<String> createPurposeCode(String value) {
        return new JAXBElement<String>(_PurposeCode_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "SWPrevYtdAmt")
    public JAXBElement<BigDecimal> createSWPrevYtdAmt(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_SWPrevYtdAmt_QNAME, BigDecimal.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "BillpayFlag")
    public JAXBElement<Integer> createBillpayFlag(Integer value) {
        return new JAXBElement<Integer>(_BillpayFlag_QNAME, Integer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "YTDTaxPaid")
    public JAXBElement<BigDecimal> createYTDTaxPaid(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_YTDTaxPaid_QNAME, BigDecimal.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "FlagHotDate")
    public JAXBElement<String> createFlagHotDate(String value) {
        return new JAXBElement<String>(_FlagHotDate_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "AcctBal")
    public JAXBElement<BigDecimal> createAcctBal(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_AcctBal_QNAME, BigDecimal.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "LastPmtSubTot")
    public JAXBElement<BigDecimal> createLastPmtSubTot(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_LastPmtSubTot_QNAME, BigDecimal.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "TotalDisb")
    public JAXBElement<String> createTotalDisb(String value) {
        return new JAXBElement<String>(_TotalDisb_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "Email2")
    public JAXBElement<String> createEmail2(String value) {
        return new JAXBElement<String>(_Email2_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "PostAdjust")
    public JAXBElement<Integer> createPostAdjust(Integer value) {
        return new JAXBElement<Integer>(_PostAdjust_QNAME, Integer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "PlacedTranDate")
    public JAXBElement<String> createPlacedTranDate(String value) {
        return new JAXBElement<String>(_PlacedTranDate_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "PreAuthXfers")
    public JAXBElement<Integer> createPreAuthXfers(Integer value) {
        return new JAXBElement<Integer>(_PreAuthXfers_QNAME, Integer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "TraceNbr1")
    public JAXBElement<Integer> createTraceNbr1(Integer value) {
        return new JAXBElement<Integer>(_TraceNbr1_QNAME, Integer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "NbrHoldRecs")
    public JAXBElement<Integer> createNbrHoldRecs(Integer value) {
        return new JAXBElement<Integer>(_NbrHoldRecs_QNAME, Integer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "EchoData")
    public JAXBElement<String> createEchoData(String value) {
        return new JAXBElement<String>(_EchoData_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "OtherFlags")
    public JAXBElement<String> createOtherFlags(String value) {
        return new JAXBElement<String>(_OtherFlags_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "RenewalAmt")
    public JAXBElement<BigDecimal> createRenewalAmt(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_RenewalAmt_QNAME, BigDecimal.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "DLExpDate")
    public JAXBElement<String> createDLExpDate(String value) {
        return new JAXBElement<String>(_DLExpDate_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "PlacedTime")
    public JAXBElement<String> createPlacedTime(String value) {
        return new JAXBElement<String>(_PlacedTime_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "MaturityDate")
    public JAXBElement<String> createMaturityDate(String value) {
        return new JAXBElement<String>(_MaturityDate_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "NumEmails")
    public JAXBElement<Integer> createNumEmails(Integer value) {
        return new JAXBElement<Integer>(_NumEmails_QNAME, Integer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "CarryoverPr")
    public JAXBElement<String> createCarryoverPr(String value) {
        return new JAXBElement<String>(_CarryoverPr_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "MinReqBal")
    public JAXBElement<String> createMinReqBal(String value) {
        return new JAXBElement<String>(_MinReqBal_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "MiddleName")
    public JAXBElement<String> createMiddleName(String value) {
        return new JAXBElement<String>(_MiddleName_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "MaxHistTran")
    public JAXBElement<String> createMaxHistTran(String value) {
        return new JAXBElement<String>(_MaxHistTran_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "BillFreqCode")
    public JAXBElement<String> createBillFreqCode(String value) {
        return new JAXBElement<String>(_BillFreqCode_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "AccrIntonEscDt")
    public JAXBElement<String> createAccrIntonEscDt(String value) {
        return new JAXBElement<String>(_AccrIntonEscDt_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", name = "LastPmtPr")
    public JAXBElement<BigDecimal> createLastPmtPr(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_LastPmtPr_QNAME, BigDecimal.class, null, value);
    }

}
