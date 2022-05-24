
package com.fidelityinfoservices.schemas.webservices.miser.vbtp;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlElementRefs;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for VBTPReply complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="VBTPReply">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}Accounts"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}AcctClass"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}AcctNbr"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}AcctStatus"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}AcctType"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}AddrSource"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}ApplCode"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}APYCalc"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}APYECalc"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}ATMODConfirmDate"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}ATMODInd"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}ATMODPostDate"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}AudioAccess"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}AvailBal"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}BillpayFlag"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}BirthDate"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}BusConsentCode"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}BusConsentDt"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}BusNoSol"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}BusPhone"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}BusPhoneExt"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}CellConsentCode"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}CellConsentDt"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}CellNoSol"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}CellPhone"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}CIBAccess"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}CIFNbr"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}Comment1"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}Comment2"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}ContinuationFlag"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}CreditReport"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}CurrYrEarnAmt"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}CustTypeCode"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}DateOpen"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}DBCODConfirmDate"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}DBCODInd"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}DBCODPostDate"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}DeceasedDt"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}DLExpDate"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}DLNbr"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}DLState"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}EchoData"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}Email"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}Email2"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}EmailConsentDt"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}EmailConsentCode"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}AnnualIncome"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}EmailItems"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}EmpCode"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}EmployeeCode"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}FaxConsentCode"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}FaxConsentDt"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}FaxNbr"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}FaxNoSol"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}FirstName"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}ForeignPrefixBusPhone"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}ForeignPrefixCellPhone"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}ForeignPrefixFax"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}ForeignPrefixHomePhone"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}FWPrevYtdAmt"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}FWYtdAmt"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}History"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}HistSeqInd"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}HistSeqNbr"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}HomeConsentCode"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}HomeConsentDt"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}HomeNoSol"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}HomePhone"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}HouseholdNbr"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}IncomeLevel"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}IntRate"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}LangPref"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}LastAcctNbr"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}LastApplCode"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}LastATMCard"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}LastCIFNbr"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}LastDepAmt"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}LastDepDate"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}LastEarnPaidAmt"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}LastEarnPaidDate"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}LastIntPaidAmt"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}LastIntPaidDate"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}LastName"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}LastStmtDate"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}LedgerBal"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}LockCode1"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}LockCode2"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}LockFlag"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}MaidenName"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}MiddleName"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}MinReqBal"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}MultiSigFlag"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}NameAddrCode1"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}NameAddrCode2"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}NameAddrCode3"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}NameAddrCode4"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}NameAddrCode5"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}NameAddrLine1"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}NameAddrLine2"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}NameAddrLine3"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}NameAddrLine4"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}NameAddrLine5"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}NamePrefix"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}NameSuffix"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}NbrChksCleared"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}NbrDep"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}NumAccounts"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}NumEmails"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}OpenReason"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}OrigBranch"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}OwnRentInd"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}PendingTrxFlag"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}PINNbr"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}PmtTypeFlag"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}PrevYrEarnAmt"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}PrevYTDIntPaid"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}PrivacyInd"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}RelFlag"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}RemUncollAmt"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}RetirementFlag"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}RetireFlag"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}PinOffset"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}XferFlag"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}PendTranFlag"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}StartDate"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}EndDate"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}MaxHistTran"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}TranOptCode"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}RetPlanNbr"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}RIBAccess"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}ScreenName"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}SelectionOpt"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}SWPrevYtdAmt"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}SWYtdAmt"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}TaxID"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}TaxIDType"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}TotalCreditAmt"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}TotATMHrdHoldAmt"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}TotChkHoldAmt"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}TotCollatHoldAmt"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}TotMgmtHoldAmt"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}TransferFlag"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}UncollAmt"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}UserNbr1"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}UserNbr2"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}UserNbr3"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}UserNbr4"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}UserNbr5"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}UserNbr6"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}WarnCode1"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}WarnCode2"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}WarnFlag"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}WDAmt1"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}WDAmt2"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}WDAmt3"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}WDAmt4"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}WDAmt5"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}WDDate1"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}WDDate2"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}WDDate3"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}WDDate4"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}WDDate5"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}WDLimitFlag"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}YTDIntPaid"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}Error"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}AcctStatus"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}AcctType"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}TaxID"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}RelFlag"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}EmployeeCode"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}TransferFlag"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}AudioAccess"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}RIBAccess"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}CIBAccess"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}HistIndicator"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}HistBuffers"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}CIFAcctNbr"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}CIFNameLine1"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}TotalCreditAmt"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}NumCreditTran"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}TotalDebitAmt"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}NumDebitTran"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}FromDate"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}ToDate"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}BufferStartBal"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}NumHistTran"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}EchoData"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}History"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}AccountNbr"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}Result"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}AcctBal"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}AvailBal"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}TotChkHoldAmt"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}TotMgmtHoldAmt"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}TotCollatHoldAmt"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}TotATMHrdHoldAmt"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}TotHoldAmt"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}NbrHoldRecs"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}Holds"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}UsedBal"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}CreditLimit"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}OverlineLimit"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}YTDIntPaid"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}PYTDIntPaid"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}AmountDue"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}LastPmtAmt"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}LastPmtDate"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}DueDate"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}IntRate"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}MinDrawAmt"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}PrBal"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}UncollLateChrgDue"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}LastDisbDate"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}LastDisbAmt"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}MinDrawAmt2"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}TotChkHoldAmt"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}TotMgmtHoldAmt"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}TotCollatHoldAmt"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}TotATMHrdHoldAmt"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}EscrowAmt"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}EscrowBal"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}YTDEscrowInt"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}PriorYearEscrowInt"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}YTDTaxPaid"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}PriorYearTaxPaid"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}PropTaxDueDt"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}PropInsDueDt"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}MultiSigFlag"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}PendingTrxFlag"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}AvailIntAmt"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}IntRate"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}MaturityDate"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}LastIntPaidAmt"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}LastIntPaidDate"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}YTDIntPaid"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}PrevYTDIntPaid"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}GraceCode"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}PrevYTDIntPenalty"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}FWYtdAmt"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}FWPrevYtdAmt"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}SWYtdAmt"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}SWPrevYtdAmt"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}PrevMatDate"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}Term"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}TermFormatCode"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}NextIntDate"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}OpeningDate"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}LedgerBal"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}YTDIntPenalty"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}OpeningAmt"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}APYCalc"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}APYECalc"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}MinBal"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}RetPlanNbr"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}IntMethodFlag"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}AudioAccess"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}RIBAccess"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}CIBAccess"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}PendingTrxFlag"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}PrBalance"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}MthlyPmtAmt"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}DtLastPmt"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}DueDt"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}YTDIntPd"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}PYTDIntPd"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}DaysPastDueDt"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}EscrowBal"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}AccrIntonEsc"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}AccrIntonEscDt"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}YTDTaxPd"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}PYTDTaxPd"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}IntRate"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}PmtTypeFlag2"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}TotAmtDue"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}OrigLnAmt"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}PostDtLastPmt"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}EffDtLastPmt"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}TranCdLastPmt"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}LastPmtAmt"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}LastPmtPr"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}LastPmtInt"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}LastPmtEsc"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}LastPmtLtChg"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}LastPmtOther"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}LastPmtIns"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}LastPmtUnap"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}LastPmtMisc"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}LastPmtSubTot"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}PrePayPnltyTrlr"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}YTDEscrowInt"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}PriorYearEscrowInt"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}PropTaxDueDt"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}PropInsDueDt"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}RenewalDt"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}RenewalAmt"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}OrigCommitAmt"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}CurrCommitAmt"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}OrigDt"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}NbrTrans"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}LastOrderNbr"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}Orders"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}InfoAttn"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}CustName"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}DeliveryAddr"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}AddtlAddr"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}City"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}State"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}ZipCode"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}Country"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}ForeignInd"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}TotTrans"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}EchoHistDate"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}EchoHistBal"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}PAN"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}PANType"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}ACHSeqNbr"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VBTPReply", propOrder = {
    "content"
})
public class VBTPReply {

    @XmlElementRefs({
        @XmlElementRef(name = "AvailBal", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "HomeNoSol", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "Comment1", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "PinOffset", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "PostDtLastPmt", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "BusConsentDt", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "Orders", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = Orders.class, required = false),
        @XmlElementRef(name = "RetPlanNbr", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "ATMODInd", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "AcctType", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "FaxConsentDt", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "Accounts", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = Accounts.class, required = false),
        @XmlElementRef(name = "BusNoSol", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "RIBAccess", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "NameAddrCode3", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "PropInsDueDt", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "NameAddrCode2", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "NumEmails", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "CIFNbr", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "LastCIFNbr", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "RemUncollAmt", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "CurrCommitAmt", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "ScreenName", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "SWYtdAmt", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "LastDepDate", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "AcctClass", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "DLState", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "LangPref", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "FromDate", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "NumHistTran", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "AccountNbr", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "MaxHistTran", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "Comment2", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "OrigCommitAmt", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "LastOrderNbr", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "MiddleName", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "NbrChksCleared", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "LastStmtDate", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "NumCreditTran", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "PINNbr", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "AnnualIncome", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "NbrDep", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "RenewalAmt", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "LastAcctNbr", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "PrBalance", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "LastATMCard", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "UserNbr3", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "MultiSigFlag", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "WDAmt1", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "OrigLnAmt", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "APYCalc", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "PropTaxDueDt", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "CreditReport", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "TranOptCode", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "UncollLateChrgDue", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "ForeignPrefixCellPhone", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "LastEarnPaidDate", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "ToDate", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "OverlineLimit", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "SWPrevYtdAmt", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "LastName", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "Holds", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = Holds.class, required = false),
        @XmlElementRef(name = "SelectionOpt", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "PYTDTaxPd", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "WDDate4", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "PrePayPnltyTrlr", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "ATMODPostDate", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "OpeningAmt", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "IntRate", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "TaxIDType", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "TranCdLastPmt", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "GraceCode", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "Term", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "NameAddrLine3", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "PriorYearTaxPaid", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "ApplCode", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "LedgerBal", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "AcctNbr", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "UncollAmt", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "DBCODConfirmDate", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "TotATMHrdHoldAmt", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "IncomeLevel", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "LastPmtMisc", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "EmailConsentCode", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "LockCode1", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "YTDIntPd", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "UserNbr6", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "WarnCode2", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "CreditLimit", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "AmountDue", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "TransferFlag", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "LockFlag", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "EffDtLastPmt", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "BirthDate", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "ATMODConfirmDate", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "DBCODPostDate", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "FaxNbr", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "YTDTaxPd", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "AccrIntonEscDt", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "CellConsentCode", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "UserNbr4", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "LastPmtOther", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "HouseholdNbr", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "WDAmt3", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "IntMethodFlag", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "AudioAccess", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "AddrSource", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "LastPmtLtChg", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "MinDrawAmt2", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "AcctBal", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "WDLimitFlag", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "HistIndicator", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "ACHSeqNbr", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "EchoData", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "ZipCode", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "NbrTrans", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "YTDIntPaid", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "LastDisbDate", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "NameAddrCode4", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "LastPmtIns", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "BufferStartBal", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "YTDIntPenalty", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "TotChkHoldAmt", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "NumAccounts", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "DueDt", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "RetirementFlag", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "StartDate", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "UserNbr2", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "DLNbr", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "MaturityDate", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "APYECalc", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "OrigBranch", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "TermFormatCode", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "CustName", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "LastPmtAmt", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "TaxID", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "HistSeqNbr", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "NextIntDate", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "CustTypeCode", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "NameAddrLine5", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "CurrYrEarnAmt", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "WDDate5", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "NameAddrLine1", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "NameAddrLine2", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "TotCollatHoldAmt", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "DLExpDate", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "PrBal", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "RelFlag", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "PmtTypeFlag2", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "OpenReason", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "Email2", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "PYTDIntPd", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "OrigDt", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "EchoHistDate", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "UserNbr5", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "DBCODInd", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "PrevYTDIntPenalty", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "PrevYrEarnAmt", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "EndDate", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "LastPmtEsc", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "FaxNoSol", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "History", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = History.class, required = false),
        @XmlElementRef(name = "EmpCode", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "WarnFlag", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "AccrIntonEsc", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "InfoAttn", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "HomeConsentCode", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "DateOpen", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "LockCode2", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "TotAmtDue", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "Country", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "NameAddrCode5", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "EscrowAmt", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "UsedBal", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "PendingTrxFlag", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "MinDrawAmt", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "TotTrans", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "NameSuffix", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "TotMgmtHoldAmt", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "LastPmtUnap", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "Email", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "AvailIntAmt", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "AcctStatus", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "ForeignPrefixFax", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "ForeignInd", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "LastPmtInt", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "YTDTaxPaid", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "EmailItems", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = EmailItems.class, required = false),
        @XmlElementRef(name = "OpeningDate", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "FirstName", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "TotalCreditAmt", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "Error", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "EmailConsentDt", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "NamePrefix", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "LastEarnPaidAmt", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "LastIntPaidDate", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "RetireFlag", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "LastDepAmt", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "WDDate2", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "CellPhone", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "TotalDebitAmt", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "CellNoSol", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "DaysPastDueDt", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "LastPmtPr", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "CIFAcctNbr", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "MaidenName", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "PAN", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "EchoHistBal", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "ContinuationFlag", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "UserNbr1", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "NameAddrLine4", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "DeceasedDt", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "DtLastPmt", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "WDDate3", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "LastApplCode", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "MinBal", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "PendTranFlag", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "HomeConsentDt", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "HistSeqInd", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "TotHoldAmt", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "WDAmt2", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "OwnRentInd", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "PmtTypeFlag", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "YTDEscrowInt", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "FWYtdAmt", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "CellConsentDt", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "BillpayFlag", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "NameAddrCode1", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "PrivacyInd", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "LastPmtDate", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "MthlyPmtAmt", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "ForeignPrefixBusPhone", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "XferFlag", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "AddtlAddr", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "PriorYearEscrowInt", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "BusPhone", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "RenewalDt", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "State", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "WDAmt5", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "MinReqBal", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "ForeignPrefixHomePhone", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "HistBuffers", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "EscrowBal", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "DeliveryAddr", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "DueDate", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "FaxConsentCode", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "NumDebitTran", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "CIFNameLine1", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "EmployeeCode", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "PANType", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "PrevYTDIntPaid", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "PYTDIntPaid", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "LastPmtSubTot", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "FWPrevYtdAmt", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "WDDate1", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "BusConsentCode", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "PrevMatDate", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "LastIntPaidAmt", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "CIBAccess", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "BusPhoneExt", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "Result", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "HomePhone", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "WDAmt4", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "City", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "WarnCode1", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "NbrHoldRecs", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "LastDisbAmt", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false)
    })
    protected List<Object> content;

    /**
     * Gets the rest of the content model. 
     * 
     * <p>
     * You are getting this "catch-all" property because of the following reason: 
     * The field name "AcctStatus" is used by two different parts of a schema. See: 
     * line 905 of file:/Users/iklassman/sources/pocs/cohesion-client/src/main/resources/vbtp_types.xsd
     * line 742 of file:/Users/iklassman/sources/pocs/cohesion-client/src/main/resources/vbtp_types.xsd
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
     * {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     * {@link JAXBElement }{@code <}{@link Integer }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link Integer }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link Orders }
     * {@link JAXBElement }{@code <}{@link Integer }{@code >}
     * {@link JAXBElement }{@code <}{@link Integer }{@code >}
     * {@link JAXBElement }{@code <}{@link Integer }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link Accounts }
     * {@link JAXBElement }{@code <}{@link Integer }{@code >}
     * {@link JAXBElement }{@code <}{@link Integer }{@code >}
     * {@link JAXBElement }{@code <}{@link Integer }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link Integer }{@code >}
     * {@link JAXBElement }{@code <}{@link Integer }{@code >}
     * {@link JAXBElement }{@code <}{@link Integer }{@code >}
     * {@link JAXBElement }{@code <}{@link Integer }{@code >}
     * {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     * {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link Integer }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link Integer }{@code >}
     * {@link JAXBElement }{@code <}{@link Long }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     * {@link JAXBElement }{@code <}{@link Integer }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link Integer }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link Integer }{@code >}
     * {@link JAXBElement }{@code <}{@link Integer }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link Integer }{@code >}
     * {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     * {@link JAXBElement }{@code <}{@link Integer }{@code >}
     * {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link Integer }{@code >}
     * {@link JAXBElement }{@code <}{@link Integer }{@code >}
     * {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     * {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     * {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link Integer }{@code >}
     * {@link JAXBElement }{@code <}{@link Integer }{@code >}
     * {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     * {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link Holds }
     * {@link JAXBElement }{@code <}{@link Integer }{@code >}
     * {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     * {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     * {@link JAXBElement }{@code <}{@link Integer }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link Integer }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     * {@link JAXBElement }{@code <}{@link Long }{@code >}
     * {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     * {@link JAXBElement }{@code <}{@link Integer }{@code >}
     * {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link Integer }{@code >}
     * {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     * {@link JAXBElement }{@code <}{@link Integer }{@code >}
     * {@link JAXBElement }{@code <}{@link Integer }{@code >}
     * {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     * {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link Integer }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link Integer }{@code >}
     * {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link Integer }{@code >}
     * {@link JAXBElement }{@code <}{@link Integer }{@code >}
     * {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     * {@link JAXBElement }{@code <}{@link Integer }{@code >}
     * {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     * {@link JAXBElement }{@code <}{@link Integer }{@code >}
     * {@link JAXBElement }{@code <}{@link Integer }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     * {@link JAXBElement }{@code <}{@link Integer }{@code >}
     * {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     * {@link JAXBElement }{@code <}{@link Integer }{@code >}
     * {@link JAXBElement }{@code <}{@link Integer }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link Integer }{@code >}
     * {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link Integer }{@code >}
     * {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     * {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     * {@link JAXBElement }{@code <}{@link Integer }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link Integer }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link Integer }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     * {@link JAXBElement }{@code <}{@link Short }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link Integer }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     * {@link JAXBElement }{@code <}{@link Integer }{@code >}
     * {@link JAXBElement }{@code <}{@link Integer }{@code >}
     * {@link JAXBElement }{@code <}{@link Integer }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link Integer }{@code >}
     * {@link JAXBElement }{@code <}{@link Integer }{@code >}
     * {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     * {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     * {@link JAXBElement }{@code <}{@link Integer }{@code >}
     * {@link History }
     * {@link JAXBElement }{@code <}{@link Integer }{@code >}
     * {@link JAXBElement }{@code <}{@link Integer }{@code >}
     * {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link Integer }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link Integer }{@code >}
     * {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link Integer }{@code >}
     * {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     * {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     * {@link JAXBElement }{@code <}{@link Integer }{@code >}
     * {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     * {@link JAXBElement }{@code <}{@link Integer }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     * {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     * {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     * {@link EmailItems }
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link Integer }{@code >}
     * {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     * {@link JAXBElement }{@code <}{@link Integer }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     * {@link JAXBElement }{@code <}{@link Integer }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link Integer }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link Integer }{@code >}
     * {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     * {@link JAXBElement }{@code <}{@link Integer }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link Integer }{@code >}
     * {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     * {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link Integer }{@code >}
     * {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     * {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link Integer }{@code >}
     * {@link JAXBElement }{@code <}{@link Integer }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link Integer }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link Integer }{@code >}
     * {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link Integer }{@code >}
     * {@link JAXBElement }{@code <}{@link Integer }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link Integer }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     * {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     * {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     * {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link Integer }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     * {@link JAXBElement }{@code <}{@link Integer }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link Integer }{@code >}
     * {@link JAXBElement }{@code <}{@link Integer }{@code >}
     * {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
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
