
package com.lendingclub.bankgateway.cohesion.soap;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlElementRefs;
import javax.xml.bind.annotation.XmlType;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java class for VBTPReply complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="VBTPReply"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}Accounts"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}AcctClass"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}AcctNbr"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}AcctStatus"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}AcctType"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}AddrSource"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}ApplCode"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}APYCalc"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}APYECalc"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}ATMODConfirmDate"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}ATMODInd"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}ATMODPostDate"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}AudioAccess"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}AvailBal"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}BillpayFlag"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}BirthDate"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}BusConsentCode"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}BusConsentDt"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}BusNoSol"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}BusPhone"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}BusPhoneExt"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}CellConsentCode"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}CellConsentDt"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}CellNoSol"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}CellPhone"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}CIBAccess"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}CIFNbr"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}Comment1"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}Comment2"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}ContinuationFlag"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}CreditReport"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}CurrYrEarnAmt"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}CustTypeCode"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}DateOpen"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}DBCODConfirmDate"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}DBCODInd"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}DBCODPostDate"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}DeceasedDt"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}DLExpDate"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}DLNbr"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}DLState"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}EchoData"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}Email"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}Email2"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}EmailConsentDt"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}EmailConsentCode"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}AnnualIncome"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}EmailItems"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}EmpCode"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}EmployeeCode"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}FaxConsentCode"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}FaxConsentDt"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}FaxNbr"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}FaxNoSol"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}FirstName"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}ForeignPrefixBusPhone"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}ForeignPrefixCellPhone"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}ForeignPrefixFax"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}ForeignPrefixHomePhone"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}FWPrevYtdAmt"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}FWYtdAmt"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}History"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}HistSeqInd"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}HistSeqNbr"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}HomeConsentCode"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}HomeConsentDt"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}HomeNoSol"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}HomePhone"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}HouseholdNbr"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}IncomeLevel"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}IntRate"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}LangPref"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}LastAcctNbr"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}LastApplCode"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}LastATMCard"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}LastCIFNbr"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}LastDepAmt"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}LastDepDate"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}LastEarnPaidAmt"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}LastEarnPaidDate"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}LastIntPaidAmt"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}LastIntPaidDate"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}LastName"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}LastStmtDate"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}LedgerBal"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}LockCode1"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}LockCode2"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}LockFlag"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}MaidenName"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}MiddleName"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}MinReqBal"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}MultiSigFlag"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}NameAddrCode1"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}NameAddrCode2"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}NameAddrCode3"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}NameAddrCode4"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}NameAddrCode5"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}NameAddrLine1"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}NameAddrLine2"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}NameAddrLine3"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}NameAddrLine4"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}NameAddrLine5"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}NamePrefix"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}NameSuffix"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}NbrChksCleared"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}NbrDep"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}NumAccounts"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}NumEmails"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}OpenReason"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}OrigBranch"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}OwnRentInd"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}PendingTrxFlag"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}PINNbr"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}PmtTypeFlag"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}PrevYrEarnAmt"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}PrevYTDIntPaid"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}PrivacyInd"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}RelFlag"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}RemUncollAmt"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}RetirementFlag"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}RetireFlag"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}PinOffset"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}XferFlag"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}PendTranFlag"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}StartDate"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}EndDate"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}MaxHistTran"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}TranOptCode"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}RetPlanNbr"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}RIBAccess"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}ScreenName"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}SelectionOpt"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}SWPrevYtdAmt"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}SWYtdAmt"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}TaxID"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}TaxIDType"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}TotalCreditAmt"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}TotATMHrdHoldAmt"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}TotChkHoldAmt"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}TotCollatHoldAmt"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}TotMgmtHoldAmt"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}TransferFlag"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}UncollAmt"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}UserNbr1"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}UserNbr2"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}UserNbr3"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}UserNbr4"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}UserNbr5"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}UserNbr6"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}WarnCode1"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}WarnCode2"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}WarnFlag"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}WDAmt1"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}WDAmt2"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}WDAmt3"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}WDAmt4"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}WDAmt5"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}WDDate1"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}WDDate2"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}WDDate3"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}WDDate4"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}WDDate5"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}WDLimitFlag"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}YTDIntPaid"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}Error"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}AcctStatus"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}AcctType"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}TaxID"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}RelFlag"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}EmployeeCode"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}TransferFlag"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}AudioAccess"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}RIBAccess"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}CIBAccess"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}HistIndicator"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}HistBuffers"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}CIFAcctNbr"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}CIFNameLine1"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}TotalCreditAmt"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}NumCreditTran"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}TotalDebitAmt"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}NumDebitTran"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}FromDate"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}ToDate"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}BufferStartBal"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}NumHistTran"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}EchoData"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}History"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}AccountNbr"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}Result"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}AcctBal"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}AvailBal"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}TotChkHoldAmt"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}TotMgmtHoldAmt"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}TotCollatHoldAmt"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}TotATMHrdHoldAmt"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}TotHoldAmt"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}NbrHoldRecs"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}Holds"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}UsedBal"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}CreditLimit"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}OverlineLimit"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}YTDIntPaid"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}PYTDIntPaid"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}AmountDue"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}LastPmtAmt"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}LastPmtDate"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}DueDate"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}IntRate"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}MinDrawAmt"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}PrBal"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}UncollLateChrgDue"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}LastDisbDate"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}LastDisbAmt"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}MinDrawAmt2"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}TotChkHoldAmt"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}TotMgmtHoldAmt"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}TotCollatHoldAmt"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}TotATMHrdHoldAmt"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}EscrowAmt"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}EscrowBal"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}YTDEscrowInt"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}PriorYearEscrowInt"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}YTDTaxPaid"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}PriorYearTaxPaid"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}PropTaxDueDt"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}PropInsDueDt"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}MultiSigFlag"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}PendingTrxFlag"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}AvailIntAmt"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}IntRate"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}MaturityDate"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}LastIntPaidAmt"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}LastIntPaidDate"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}YTDIntPaid"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}PrevYTDIntPaid"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}GraceCode"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}PrevYTDIntPenalty"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}FWYtdAmt"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}FWPrevYtdAmt"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}SWYtdAmt"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}SWPrevYtdAmt"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}PrevMatDate"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}Term"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}TermFormatCode"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}NextIntDate"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}OpeningDate"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}LedgerBal"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}YTDIntPenalty"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}OpeningAmt"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}APYCalc"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}APYECalc"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}MinBal"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}RetPlanNbr"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}IntMethodFlag"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}AudioAccess"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}RIBAccess"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}CIBAccess"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}PendingTrxFlag"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}PrBalance"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}MthlyPmtAmt"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}DtLastPmt"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}DueDt"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}YTDIntPd"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}PYTDIntPd"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}DaysPastDueDt"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}EscrowBal"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}AccrIntonEsc"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}AccrIntonEscDt"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}YTDTaxPd"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}PYTDTaxPd"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}IntRate"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}PmtTypeFlag2"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}TotAmtDue"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}OrigLnAmt"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}PostDtLastPmt"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}EffDtLastPmt"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}TranCdLastPmt"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}LastPmtAmt"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}LastPmtPr"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}LastPmtInt"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}LastPmtEsc"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}LastPmtLtChg"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}LastPmtOther"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}LastPmtIns"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}LastPmtUnap"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}LastPmtMisc"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}LastPmtSubTot"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}PrePayPnltyTrlr"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}YTDEscrowInt"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}PriorYearEscrowInt"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}PropTaxDueDt"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}PropInsDueDt"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}RenewalDt"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}RenewalAmt"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}OrigCommitAmt"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}CurrCommitAmt"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}OrigDt"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}NbrTrans"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}LastOrderNbr"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}Orders"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}InfoAttn"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}CustName"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}DeliveryAddr"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}AddtlAddr"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}City"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}State"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}ZipCode"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}Country"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}ForeignInd"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}TotTrans"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}EchoHistDate"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}EchoHistBal"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}PAN"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}PANType"/&gt;
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}ACHSeqNbr"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VBTPReply", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", propOrder = {
    "content"
})
public class VBTPReply {

    @XmlElementRefs({
        @XmlElementRef(name = "Accounts", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = Accounts.class, required = false),
        @XmlElementRef(name = "AcctClass", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "AcctNbr", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "AcctStatus", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "AcctType", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "AddrSource", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "ApplCode", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "APYCalc", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "APYECalc", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "ATMODConfirmDate", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "ATMODInd", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "ATMODPostDate", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "AudioAccess", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "AvailBal", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "BillpayFlag", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "BirthDate", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "BusConsentCode", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "BusConsentDt", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "BusNoSol", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "BusPhone", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "BusPhoneExt", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "CellConsentCode", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "CellConsentDt", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "CellNoSol", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "CellPhone", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "CIBAccess", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "CIFNbr", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "Comment1", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "Comment2", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "ContinuationFlag", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "CreditReport", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "CurrYrEarnAmt", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "CustTypeCode", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "DateOpen", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "DBCODConfirmDate", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "DBCODInd", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "DBCODPostDate", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "DeceasedDt", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "DLExpDate", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "DLNbr", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "DLState", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "EchoData", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "Email", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "Email2", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "EmailConsentDt", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "EmailConsentCode", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "AnnualIncome", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "EmailItems", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = EmailItems.class, required = false),
        @XmlElementRef(name = "EmpCode", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "EmployeeCode", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "FaxConsentCode", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "FaxConsentDt", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "FaxNbr", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "FaxNoSol", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "FirstName", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "ForeignPrefixBusPhone", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "ForeignPrefixCellPhone", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "ForeignPrefixFax", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "ForeignPrefixHomePhone", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "FWPrevYtdAmt", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "FWYtdAmt", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "History", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = History.class, required = false),
        @XmlElementRef(name = "HistSeqInd", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "HistSeqNbr", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "HomeConsentCode", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "HomeConsentDt", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "HomeNoSol", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "HomePhone", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "HouseholdNbr", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "IncomeLevel", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "IntRate", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "LangPref", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "LastAcctNbr", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "LastApplCode", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "LastATMCard", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "LastCIFNbr", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "LastDepAmt", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "LastDepDate", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "LastEarnPaidAmt", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "LastEarnPaidDate", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "LastIntPaidAmt", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "LastIntPaidDate", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "LastName", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "LastStmtDate", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "LedgerBal", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "LockCode1", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "LockCode2", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "LockFlag", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "MaidenName", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "MiddleName", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "MinReqBal", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "MultiSigFlag", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "NameAddrCode1", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "NameAddrCode2", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "NameAddrCode3", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "NameAddrCode4", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "NameAddrCode5", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "NameAddrLine1", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "NameAddrLine2", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "NameAddrLine3", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "NameAddrLine4", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "NameAddrLine5", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "NamePrefix", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "NameSuffix", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "NbrChksCleared", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "NbrDep", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "NumAccounts", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "NumEmails", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "OpenReason", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "OrigBranch", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "OwnRentInd", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "PendingTrxFlag", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "PINNbr", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "PmtTypeFlag", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "PrevYrEarnAmt", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "PrevYTDIntPaid", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "PrivacyInd", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "RelFlag", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "RemUncollAmt", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "RetirementFlag", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "RetireFlag", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "PinOffset", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "XferFlag", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "PendTranFlag", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "StartDate", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "EndDate", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "MaxHistTran", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "TranOptCode", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "RetPlanNbr", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "RIBAccess", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "ScreenName", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "SelectionOpt", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "SWPrevYtdAmt", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "SWYtdAmt", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "TaxID", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "TaxIDType", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "TotalCreditAmt", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "TotATMHrdHoldAmt", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "TotChkHoldAmt", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "TotCollatHoldAmt", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "TotMgmtHoldAmt", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "TransferFlag", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "UncollAmt", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "UserNbr1", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "UserNbr2", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "UserNbr3", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "UserNbr4", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "UserNbr5", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "UserNbr6", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "WarnCode1", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "WarnCode2", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "WarnFlag", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "WDAmt1", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "WDAmt2", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "WDAmt3", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "WDAmt4", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "WDAmt5", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "WDDate1", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "WDDate2", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "WDDate3", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "WDDate4", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "WDDate5", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "WDLimitFlag", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "YTDIntPaid", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "Error", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "HistIndicator", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "HistBuffers", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "CIFAcctNbr", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "CIFNameLine1", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "NumCreditTran", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "TotalDebitAmt", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "NumDebitTran", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "FromDate", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "ToDate", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "BufferStartBal", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "NumHistTran", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "AccountNbr", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "Result", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "AcctBal", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "TotHoldAmt", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "NbrHoldRecs", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "Holds", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = Holds.class, required = false),
        @XmlElementRef(name = "UsedBal", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "CreditLimit", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "OverlineLimit", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "PYTDIntPaid", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "AmountDue", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "LastPmtAmt", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "LastPmtDate", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "DueDate", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "MinDrawAmt", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "PrBal", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "UncollLateChrgDue", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "LastDisbDate", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "LastDisbAmt", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "MinDrawAmt2", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "EscrowAmt", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "EscrowBal", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "YTDEscrowInt", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "PriorYearEscrowInt", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "YTDTaxPaid", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "PriorYearTaxPaid", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "PropTaxDueDt", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "PropInsDueDt", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "AvailIntAmt", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "MaturityDate", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "GraceCode", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "PrevYTDIntPenalty", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "PrevMatDate", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "Term", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "TermFormatCode", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "NextIntDate", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "OpeningDate", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "YTDIntPenalty", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "OpeningAmt", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "MinBal", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "IntMethodFlag", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "PrBalance", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "MthlyPmtAmt", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "DtLastPmt", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "DueDt", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "YTDIntPd", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "PYTDIntPd", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "DaysPastDueDt", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "AccrIntonEsc", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "AccrIntonEscDt", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "YTDTaxPd", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "PYTDTaxPd", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "PmtTypeFlag2", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "TotAmtDue", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "OrigLnAmt", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "PostDtLastPmt", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "EffDtLastPmt", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "TranCdLastPmt", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "LastPmtPr", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "LastPmtInt", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "LastPmtEsc", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "LastPmtLtChg", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "LastPmtOther", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "LastPmtIns", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "LastPmtUnap", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "LastPmtMisc", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "LastPmtSubTot", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "PrePayPnltyTrlr", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "RenewalDt", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "RenewalAmt", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "OrigCommitAmt", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "CurrCommitAmt", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "OrigDt", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "NbrTrans", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "LastOrderNbr", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "Orders", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = Orders.class, required = false),
        @XmlElementRef(name = "InfoAttn", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "CustName", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "DeliveryAddr", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "AddtlAddr", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "City", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "State", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "ZipCode", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "Country", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "ForeignInd", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "TotTrans", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "EchoHistDate", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "EchoHistBal", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "PAN", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "PANType", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "ACHSeqNbr", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false)
    })
    protected List<Object> content;

    /**
     * Gets the rest of the content model. 
     * 
     * <p>
     * You are getting this "catch-all" property because of the following reason: 
     * The field name "AcctStatus" is used by two different parts of a schema. See: 
     * line 905 of file:/Users/iklassman/sources/bank-gateway-service/bank-gateway-cohesion/src/main/resources/vbtp_types.xsd
     * line 742 of file:/Users/iklassman/sources/bank-gateway-service/bank-gateway-cohesion/src/main/resources/vbtp_types.xsd
     * <p>
     * To get rid of this property, apply a property customization to one 
     * of both of the following declarations to change their names: 
     * Gets the value of the content property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the content property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getContent().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Accounts }
     * {@link JAXBElement }{@code <}{@link Integer }{@code >}
     * {@link JAXBElement }{@code <}{@link Long }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link Integer }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     * {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link Integer }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link Integer }{@code >}
     * {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     * {@link JAXBElement }{@code <}{@link Integer }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link Integer }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link Integer }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link Integer }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link Integer }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link Integer }{@code >}
     * {@link JAXBElement }{@code <}{@link Integer }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link Integer }{@code >}
     * {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link Integer }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link EmailItems }
     * {@link JAXBElement }{@code <}{@link Integer }{@code >}
     * {@link JAXBElement }{@code <}{@link Integer }{@code >}
     * {@link JAXBElement }{@code <}{@link Integer }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link Integer }{@code >}
     * {@link JAXBElement }{@code <}{@link Integer }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     * {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     * {@link History }
     * {@link JAXBElement }{@code <}{@link Integer }{@code >}
     * {@link JAXBElement }{@code <}{@link Integer }{@code >}
     * {@link JAXBElement }{@code <}{@link Integer }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link Integer }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link Integer }{@code >}
     * {@link JAXBElement }{@code <}{@link Integer }{@code >}
     * {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link Integer }{@code >}
     * {@link JAXBElement }{@code <}{@link Integer }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link Integer }{@code >}
     * {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     * {@link JAXBElement }{@code <}{@link Integer }{@code >}
     * {@link JAXBElement }{@code <}{@link Integer }{@code >}
     * {@link JAXBElement }{@code <}{@link Integer }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link Integer }{@code >}
     * {@link JAXBElement }{@code <}{@link Integer }{@code >}
     * {@link JAXBElement }{@code <}{@link Integer }{@code >}
     * {@link JAXBElement }{@code <}{@link Integer }{@code >}
     * {@link JAXBElement }{@code <}{@link Integer }{@code >}
     * {@link JAXBElement }{@code <}{@link Integer }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link Integer }{@code >}
     * {@link JAXBElement }{@code <}{@link Integer }{@code >}
     * {@link JAXBElement }{@code <}{@link Integer }{@code >}
     * {@link JAXBElement }{@code <}{@link Integer }{@code >}
     * {@link JAXBElement }{@code <}{@link Integer }{@code >}
     * {@link JAXBElement }{@code <}{@link Short }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link Integer }{@code >}
     * {@link JAXBElement }{@code <}{@link Integer }{@code >}
     * {@link JAXBElement }{@code <}{@link Integer }{@code >}
     * {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     * {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link Integer }{@code >}
     * {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     * {@link JAXBElement }{@code <}{@link Integer }{@code >}
     * {@link JAXBElement }{@code <}{@link Integer }{@code >}
     * {@link JAXBElement }{@code <}{@link Integer }{@code >}
     * {@link JAXBElement }{@code <}{@link Integer }{@code >}
     * {@link JAXBElement }{@code <}{@link Integer }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link Integer }{@code >}
     * {@link JAXBElement }{@code <}{@link Integer }{@code >}
     * {@link JAXBElement }{@code <}{@link Integer }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link Integer }{@code >}
     * {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     * {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link Integer }{@code >}
     * {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     * {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     * {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     * {@link JAXBElement }{@code <}{@link Integer }{@code >}
     * {@link JAXBElement }{@code <}{@link Integer }{@code >}
     * {@link JAXBElement }{@code <}{@link Integer }{@code >}
     * {@link JAXBElement }{@code <}{@link Integer }{@code >}
     * {@link JAXBElement }{@code <}{@link Integer }{@code >}
     * {@link JAXBElement }{@code <}{@link Integer }{@code >}
     * {@link JAXBElement }{@code <}{@link Integer }{@code >}
     * {@link JAXBElement }{@code <}{@link Integer }{@code >}
     * {@link JAXBElement }{@code <}{@link Integer }{@code >}
     * {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     * {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     * {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     * {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     * {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link Integer }{@code >}
     * {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link Integer }{@code >}
     * {@link JAXBElement }{@code <}{@link Integer }{@code >}
     * {@link JAXBElement }{@code <}{@link Integer }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link Integer }{@code >}
     * {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     * {@link JAXBElement }{@code <}{@link Integer }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link Integer }{@code >}
     * {@link JAXBElement }{@code <}{@link Long }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     * {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     * {@link JAXBElement }{@code <}{@link Integer }{@code >}
     * {@link Holds }
     * {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     * {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     * {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     * {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     * {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     * {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     * {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     * {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     * {@link JAXBElement }{@code <}{@link Integer }{@code >}
     * {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     * {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     * {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     * {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     * {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     * {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link Integer }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     * {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     * {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     * {@link JAXBElement }{@code <}{@link Integer }{@code >}
     * {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     * {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     * {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     * {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     * {@link JAXBElement }{@code <}{@link Integer }{@code >}
     * {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     * {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     * {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     * {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     * {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     * {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     * {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     * {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     * {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     * {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     * {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     * {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link Integer }{@code >}
     * {@link JAXBElement }{@code <}{@link Integer }{@code >}
     * {@link Orders }
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link Integer }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * 
     */
    public List<Object> getContent() {
        if (content == null) {
            content = new ArrayList<Object>();
        }
        return this.content;
    }

}
