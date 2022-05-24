
package com.fidelityinfoservices.schemas.webservices.miser.vbtp;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlElementRefs;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice maxOccurs="unbounded" minOccurs="0">
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}ApplCode"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}AcctNbr"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}OwnerCIFNbr"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}RelCode"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}MailOrder"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}FindCIFNbr"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}FindRelCode"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}FindMailOrder"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}AcctTitle"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}AcctType"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}AudioAccess"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}RIBAccess"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}CIBAccess"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}RMBAccess"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}CMBAccess"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}EvalAcctStatus"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}AcctStatus"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}KICode"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}RegPlanFlag"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}AltNameAddr"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}MailCode"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}LockFlags"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}WarnFlags"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}OtherFlags"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}TransferReceiptFlag"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}TransferDonorFlag"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}AcctDesc"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}EmpFlag"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}TransferFlag"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}RegDLimitFlag"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}PendVBTPTransferFlag"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}MultipleSig"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}OrigBranch"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}StmtFlag"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}StmtCycleCode"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}PassbookStmtCode"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}StmtCombCode"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}StmtCombAppl"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}StmtCombAcct"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}AcctBal"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}AvailBal"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}ODAvailBal"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}LastStmtDate"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}LastStmtBal"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}PrevStmtDate"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}CompoundedInt"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}LastDepositAmt"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}LastDepositDate"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}LastIntAmt"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}LastIntDate"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}IntRate"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}MaturityDate"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}LastActivityDate"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}YTDInt"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}PrevYearYTDInt"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}YTDFederalHold"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}YTDStateHold"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}YTDIntPenalty"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}PrevYearYTDIntPenalty"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}Term"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}TermFormatCode"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}PrevMaturityDate"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}PrevMaturityAmt"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}NextIntDate"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}OpeningDate"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}OpeningAmt"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}MinBal"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}DirectDepositFlag"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}TranAcctInd"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}TranCountRegD"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}GraceDays"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}PreAuthXfers"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}ATMODInd"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}ATMODConfirmDate"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}ATMODPostDate"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}DBCODInd"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}DBCODConfirmDate"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}DBCODPostDate"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}AcctClass"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}APYCalc"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}APYECalc"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}RetPlanNbr"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}MthlyPmtAmt"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}OrigDate"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}NoteDate"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}OrigLnAmt"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}LastBillDate"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}NextBillDate"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}YTDIntPaid"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}PrevYTDIntPaid"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}YTDTaxes"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}PrevYTDTaxes"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}DaysPastDueDt"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}PmtTypeFlag"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}PmtTypeFlag2"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}TotAmtDue"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}DueDate"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}LastPmtDate"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}EffDtLastPmt"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}TranCdLastPmt"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}LastPmtAmt"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}LastPmtPr"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}LastPmtInt"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}LastPmtEsc"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}LastPmtEscInt"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}LastPmtLtChg"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}LastPmtOther"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}LastPmtIns"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}LastPmtUnap"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}LastPmtMisc"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}LastPmtSubTot"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}PrePayPnltyTrlr"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}PayMethod"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}SkipPayment"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}IntMethod"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}CollectionsFlag"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}LateDays"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}EscrowBal"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}IntAccrual"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}IntAccrualDate"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}PayoffAmt"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}PayoffEffDate"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}PerDiemInt"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}LastDisbAmt"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}LastDisbDate"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}RenewalDt"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}RenewalAmt"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}OrigCommitAmt"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}CurrCommitAmt"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}PriAcctNbr"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}ATMApplCode"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}ATMAcctNbr"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}CardTypeCode"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}PANLength"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}CardClassDesc"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}CardType"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}CardClass"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}ProdCode"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}DateOpened"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}EffDate"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}ExpDate"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}LastUsed"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}LastFMDate"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}LastOrderDate"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}StatusInd"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}CancelInd"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}FlagHotDate"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}RestrictInd"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}LostInd"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}StolenInd"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}CIFNbr"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}EmbossName1"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}EmbossName2"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}ApplCode"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}AcctNbr"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}AcctStatus"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}RelCode"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}OpeningDate"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}StatementDate"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}OtherFlag"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}StmtCycleCode"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}PassbookStmtInd"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}StmtCombCode"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}PriApplCode"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}PriAcctNbr"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}MinCheckAmt" minOccurs="0"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}TotChkHoldAmt" minOccurs="0"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}TotMgmtHoldAmt" minOccurs="0"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}TotCollatHoldAmt" minOccurs="0"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}TotATMHrdHoldAmt" minOccurs="0"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}TotHoldAmt" minOccurs="0"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}TotHoldLessCheckHoldAmt" minOccurs="0"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}ATMODInd" minOccurs="0"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}ATMODConfirmDate" minOccurs="0"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}ATMODPostDate" minOccurs="0"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}DBCODInd" minOccurs="0"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}DBCODConfirmDate" minOccurs="0"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}DBCODPostDate" minOccurs="0"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}ApplCode"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}AcctNbr" minOccurs="0"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}OwnerCIFNbr" minOccurs="0"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}RelCode" minOccurs="0"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}MailOrder" minOccurs="0"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}FindCIFNbr" minOccurs="0"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}FindRelCode" minOccurs="0"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}FindMailOrder" minOccurs="0"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}AcctTitle" minOccurs="0"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}AcctType" minOccurs="0"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}AudioAccess" minOccurs="0"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}RIBAccess" minOccurs="0"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}CIBAccess" minOccurs="0"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}RMBAccess" minOccurs="0"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}CMBAccess" minOccurs="0"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}EvalAcctStatus" minOccurs="0"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}AcctStatus" minOccurs="0"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}KICode" minOccurs="0"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}RegPlanFlag" minOccurs="0"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}AltNameAddr" minOccurs="0"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}MailCode" minOccurs="0"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}LockFlags" minOccurs="0"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}WarnFlags" minOccurs="0"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}OtherFlags" minOccurs="0"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}TransferReceiptFlag" minOccurs="0"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}TransferDonorFlag" minOccurs="0"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}AcctDesc" minOccurs="0"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}EmpFlag" minOccurs="0"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}TransferFlag" minOccurs="0"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}RegDLimitFlag" minOccurs="0"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}PendVBTPTransferFlag" minOccurs="0"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}MultipleSig" minOccurs="0"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}OrigBranch" minOccurs="0"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}StmtFlag" minOccurs="0"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}StmtCycleCode" minOccurs="0"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}PassbookStmtCode" minOccurs="0"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}StmtCombCode" minOccurs="0"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}StmtCombAppl" minOccurs="0"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}StmtCombAcct" minOccurs="0"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}AcctBal" minOccurs="0"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}AvailBal" minOccurs="0"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}ODAvailBal" minOccurs="0"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}LastStmtDate" minOccurs="0"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}LastStmtBal" minOccurs="0"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}PrevStmtDate" minOccurs="0"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}CompoundedInt" minOccurs="0"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}LastDepositAmt" minOccurs="0"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}LastDepositDate" minOccurs="0"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}LastIntAmt" minOccurs="0"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}LastIntDate" minOccurs="0"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}IntRate" minOccurs="0"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}LastActivityDate" minOccurs="0"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}YTDInt" minOccurs="0"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}PrevYearYTDInt" minOccurs="0"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}YTDFederalHold" minOccurs="0"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}YTDStateHold" minOccurs="0"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}NextIntDate" minOccurs="0"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}OpeningDate" minOccurs="0"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}OpeningAmt" minOccurs="0"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}MinCheckAmt" minOccurs="0"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}DirectDepositFlag" minOccurs="0"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}TranAcctInd" minOccurs="0"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}TranCountRegD" minOccurs="0"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}PreAuthXfers" minOccurs="0"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}NbrChksCleared" minOccurs="0"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}BillpayFlag" minOccurs="0"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}UserNbr1" minOccurs="0"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}UserNbr2" minOccurs="0"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}UserNbr3" minOccurs="0"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}UserNbr4" minOccurs="0"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}UserNbr5" minOccurs="0"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}UserNbr6" minOccurs="0"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}UnColAmt1Day" minOccurs="0"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}UnColAmtRemain" minOccurs="0"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}TotChkHoldAmt" minOccurs="0"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}TotMgmtHoldAmt" minOccurs="0"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}TotCollatHoldAmt" minOccurs="0"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}TotATMHrdHoldAmt" minOccurs="0"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}TotHoldAmt" minOccurs="0"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}TotHoldLessCheckHoldAmt" minOccurs="0"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}ATMODInd" minOccurs="0"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}ATMODConfirmDate" minOccurs="0"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}ATMODPostDate" minOccurs="0"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}DBCODInd" minOccurs="0"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}DBCODConfirmDate" minOccurs="0"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}DBCODPostDate" minOccurs="0"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}AcctClass" minOccurs="0"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}APYCalc" minOccurs="0"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}APYECalc" minOccurs="0"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}RetPlanNbr" minOccurs="0"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}PriAcctNbr" minOccurs="0"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}ATMApplCode" minOccurs="0"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}ATMAcctNbr" minOccurs="0"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}CardTypeCode" minOccurs="0"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}PANLength" minOccurs="0"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}CardClassDesc" minOccurs="0"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}CardType" minOccurs="0"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}CardClass" minOccurs="0"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}ProdCode" minOccurs="0"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}DateOpened" minOccurs="0"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}EffDate" minOccurs="0"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}ExpDate" minOccurs="0"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}LastUsed" minOccurs="0"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}LastFMDate" minOccurs="0"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}LastOrderDate" minOccurs="0"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}StatusInd" minOccurs="0"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}CancelInd" minOccurs="0"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}FlagHotDate" minOccurs="0"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}RestrictInd" minOccurs="0"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}LostInd" minOccurs="0"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}StolenInd" minOccurs="0"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}CIFNbr" minOccurs="0"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}EmbossName1" minOccurs="0"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}EmbossName2" minOccurs="0"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}UsedBal"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}AvailBal"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}CreditLimit"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}OverlineLimit"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}PayoffBal"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}PayoffEffDate"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}PerDiemInt"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}LastBillDt"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}NextBillDt"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}LastStmtDt"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}LastActivityDate"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}YTDIntPaid"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}PrevYTDIntPaid"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}MaturityDate"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}AmountDue"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}DueDate"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}PmtTypeFlag"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}LastPmtAmt"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}LastPmtDate"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}CollFlag"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}IntRate"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}UncollLateChrgDue"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}LastDisbDate"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}LastDisbAmt"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}MinDrawAmt"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}TotChkHoldAmt"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}TotMgmtHoldAmt"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}TotCollatHoldAmt"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}TotATMHrdHoldAmt"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}TotHoldAmt"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}TotHoldLessCheckHoldAmt"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}EscrowAmt"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}EscrowBal"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}DateOpened"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}AccruInt"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}AccruIntDate"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}DisbAmt"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}BillIntDue"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}CarryoverDate"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}CarryoverEsc"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}CarryoverInt"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}CarryoverPr"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}ControlledBal"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}CustBal"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}LastMonetaryTranDate"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}IntCalcDate"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}LoanAcctNbrLink"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}LastTranBranch"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}NAICSCode"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}OrigAmt"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}OrigLoanTerm"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}PrepaidInt"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}PrimeRateCode"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}PrimeRateVar"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}PrimeRateVarCode"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}PropType"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}PurgeHash"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}PurposeCode"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}SubAcctType"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}TicklerCode"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}TicklerDate"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}RptCode1098"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}RptFlag1098"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}IntCalcBasis"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}IntCalcCode"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}IntColCode"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}DocMethodCode"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}BillFreqCode"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}LedgerBal"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}LastIntPaidDate"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}TotalAmt"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}YTDAvgBal"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}AvgUnusedBal"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}ClosingFee"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}LastCalcDate"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}FeePaymentDueDt"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}YTDFeesPaid"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}LineInvPct"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}LineInvType"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}LateChgAmt"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}LateChgTotal"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}LineUnusedAmt"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}LastTranBranch"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}LineTypeCode"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}LineMasterNbr"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}MaxLoanLimit"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}MaxNoteAmt"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}MaxOutstandingPr"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}LineOfficer"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}PrevYTDFeesPaid"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}ReviewDate"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}ReviewFlag"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}ReviewFreqCode"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}TotalDisb"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}TotalLoansAttached"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}TotalOutstandingAmt"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}TotalOutstandingPrevAmt"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}TotalDisbReq"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}UnusedAmt"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}UpdateMonth"/>
 *         &lt;element ref="{http://schemas.fidelityinfoservices.com/webservices/miser/vbtp}BusinessTransInd"/>
 *       &lt;/choice>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "applCodeOrAcctNbrOrOwnerCIFNbr"
})
@XmlRootElement(name = "Account")
public class Account {

    @XmlElementRefs({
        @XmlElementRef(name = "TransferReceiptFlag", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "StmtCycleCode", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "AvailBal", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "IntCalcBasis", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "LateChgTotal", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "StmtCombCode", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "CMBAccess", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "RetPlanNbr", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "ATMODInd", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "AcctType", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "LastIntAmt", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "RIBAccess", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "PassbookStmtCode", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "FlagHotDate", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "CardType", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "ATMApplCode", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "CIFNbr", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "PrevMaturityDate", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "CurrCommitAmt", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "AcctDesc", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "TranAcctInd", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "RegDLimitFlag", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "AcctClass", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "IntCalcCode", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "LastCalcDate", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "PrimeRateVar", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "IntColCode", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "RelCode", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "KICode", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "OrigCommitAmt", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "EmbossName1", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "CardClass", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "NbrChksCleared", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "TotalDisb", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "LastStmtDate", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "PrimeRateVarCode", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "ControlledBal", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "RenewalAmt", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "ReviewFreqCode", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "PendVBTPTransferFlag", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "UserNbr3", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "AccruInt", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "OrigLnAmt", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "LastDepositDate", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "APYCalc", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "CompoundedInt", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "PropType", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "YTDTaxes", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "UncollLateChrgDue", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "CarryoverInt", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "OtherFlag", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "SkipPayment", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "OverlineLimit", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "BillIntDue", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "FindCIFNbr", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "LastBillDt", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "AccruIntDate", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "PrePayPnltyTrlr", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "OpeningAmt", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "ATMODPostDate", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "IntRate", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "TranCdLastPmt", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "Term", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "ApplCode", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "DisbAmt", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "CarryoverEsc", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "TotHoldLessCheckHoldAmt", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "LedgerBal", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "AcctNbr", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "DBCODConfirmDate", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "LineMasterNbr", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "AltNameAddr", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "TotATMHrdHoldAmt", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "LastIntDate", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "LastPmtMisc", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "PayoffBal", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "LineInvPct", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "UserNbr6", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "MailCode", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "CreditLimit", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "AmountDue", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "TicklerDate", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "TransferFlag", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "MaxOutstandingPr", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "NoteDate", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "EffDtLastPmt", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "NAICSCode", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "LastMonetaryTranDate", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "ATMODConfirmDate", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "DBCODPostDate", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "LastPmtOther", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "UserNbr4", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "PriApplCode", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "PerDiemInt", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "AudioAccess", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "LastPmtLtChg", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "CollFlag", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "CarryoverDate", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "AcctBal", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "YTDFeesPaid", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "OrigLoanTerm", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "YTDIntPaid", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "UnColAmt1Day", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "LastDisbDate", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "LastPmtIns", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "DirectDepositFlag", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "YTDIntPenalty", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "TotChkHoldAmt", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "MailOrder", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "EmbossName2", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "BillFreqCode", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "LateChgAmt", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "IntMethod", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "PrevYTDTaxes", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "UserNbr2", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "MaturityDate", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "StatementDate", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "OrigBranch", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "TermFormatCode", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "APYECalc", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "LastPmtAmt", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "NextIntDate", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "StmtCombAcct", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "DateOpened", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "FindRelCode", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "CollectionsFlag", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "GraceDays", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "RestrictInd", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "FeePaymentDueDt", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "TotCollatHoldAmt", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "StmtCombAppl", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "PmtTypeFlag2", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "LineTypeCode", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "CustBal", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "PreAuthXfers", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "OrigDate", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "PANLength", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "PrimeRateCode", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "PurposeCode", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "UserNbr5", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "DBCODInd", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "OrigAmt", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "LastPmtEsc", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "NextBillDt", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "UnColAmtRemain", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "CarryoverPr", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "BusinessTransInd", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "PrevYearYTDInt", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "TotAmtDue", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "CardClassDesc", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "TotalOutstandingAmt", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "StmtFlag", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "EscrowAmt", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "LastActivityDate", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "LastBillDate", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "LateDays", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "CancelInd", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "StolenInd", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "UsedBal", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "ProdCode", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "MinDrawAmt", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "TotMgmtHoldAmt", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "LastPmtUnap", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "LastTranBranch", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "LastStmtBal", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "AcctStatus", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "ClosingFee", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "LastPmtInt", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "AcctTitle", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "UnusedAmt", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "WarnFlags", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "MaxLoanLimit", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "LockFlags", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "PayoffAmt", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "OpeningDate", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "LoanAcctNbrLink", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "ReviewDate", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "TotalDisbReq", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "RptCode1098", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "LastDepositAmt", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "LastIntPaidDate", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "SubAcctType", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "ExpDate", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "PrepaidInt", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "IntCalcDate", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "ATMAcctNbr", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "TotalOutstandingPrevAmt", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "PassbookStmtInd", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "FindMailOrder", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "DocMethodCode", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "DaysPastDueDt", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "LastPmtPr", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "YTDStateHold", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "LastPmtEscInt", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "PrevYearYTDIntPenalty", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "IntAccrual", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "UserNbr1", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "MinBal", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "YTDAvgBal", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "TotalAmt", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "PrevYTDFeesPaid", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "MinCheckAmt", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "EmpFlag", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "TotHoldAmt", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "UpdateMonth", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "PmtTypeFlag", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "PrevStmtDate", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "EffDate", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "LostInd", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "LineOfficer", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "EvalAcctStatus", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "LastStmtDt", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "TotalLoansAttached", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "RptFlag1098", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "BillpayFlag", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "StatusInd", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "LineUnusedAmt", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "LastPmtDate", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "MthlyPmtAmt", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "PayoffEffDate", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "YTDInt", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "IntAccrualDate", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "MultipleSig", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "ReviewFlag", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "PayMethod", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "LastOrderDate", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "LastFMDate", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "LastUsed", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "RenewalDt", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "TranCountRegD", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "PurgeHash", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "YTDFederalHold", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "MaxNoteAmt", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "PriAcctNbr", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "OtherFlags", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "ODAvailBal", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "EscrowBal", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "DueDate", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "CardTypeCode", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "PrevMaturityAmt", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "PrevYTDIntPaid", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "LastPmtSubTot", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "RMBAccess", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "CIBAccess", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "NextBillDate", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "RegPlanFlag", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "TransferDonorFlag", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "LineInvType", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "AvgUnusedBal", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "LastDisbAmt", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "TicklerCode", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "OwnerCIFNbr", namespace = "http://schemas.fidelityinfoservices.com/webservices/miser/vbtp", type = JAXBElement.class, required = false)
    })
    protected List<JAXBElement<? extends Serializable>> applCodeOrAcctNbrOrOwnerCIFNbr;

    /**
     * Gets the value of the applCodeOrAcctNbrOrOwnerCIFNbr property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the applCodeOrAcctNbrOrOwnerCIFNbr property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getApplCodeOrAcctNbrOrOwnerCIFNbr().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link Short }{@code >}
     * {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link Integer }{@code >}
     * {@link JAXBElement }{@code <}{@link Integer }{@code >}
     * {@link JAXBElement }{@code <}{@link Integer }{@code >}
     * {@link JAXBElement }{@code <}{@link Integer }{@code >}
     * {@link JAXBElement }{@code <}{@link Integer }{@code >}
     * {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     * {@link JAXBElement }{@code <}{@link Integer }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link Integer }{@code >}
     * {@link JAXBElement }{@code <}{@link Integer }{@code >}
     * {@link JAXBElement }{@code <}{@link Integer }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link Integer }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link Integer }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link Integer }{@code >}
     * {@link JAXBElement }{@code <}{@link Integer }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link Integer }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     * {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     * {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
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
     * {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link Integer }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     * {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     * {@link JAXBElement }{@code <}{@link Long }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     * {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link Integer }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     * {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     * {@link JAXBElement }{@code <}{@link Integer }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     * {@link JAXBElement }{@code <}{@link Integer }{@code >}
     * {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
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
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link Integer }{@code >}
     * {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     * {@link JAXBElement }{@code <}{@link Integer }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link Short }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     * {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link Integer }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link Integer }{@code >}
     * {@link JAXBElement }{@code <}{@link Integer }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link Integer }{@code >}
     * {@link JAXBElement }{@code <}{@link Integer }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link Integer }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link Integer }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link Integer }{@code >}
     * {@link JAXBElement }{@code <}{@link Integer }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     * {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link Integer }{@code >}
     * {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link Integer }{@code >}
     * {@link JAXBElement }{@code <}{@link Integer }{@code >}
     * {@link JAXBElement }{@code <}{@link Integer }{@code >}
     * {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     * {@link JAXBElement }{@code <}{@link Integer }{@code >}
     * {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     * {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     * {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
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
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link Integer }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link Integer }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     * {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     * {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     * {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     * {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     * {@link JAXBElement }{@code <}{@link Integer }{@code >}
     * {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     * {@link JAXBElement }{@code <}{@link Integer }{@code >}
     * {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link Integer }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link Integer }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link Integer }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link Integer }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link Integer }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link Integer }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     * {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link Integer }{@code >}
     * {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     * {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     * {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     * {@link JAXBElement }{@code <}{@link Integer }{@code >}
     * {@link JAXBElement }{@code <}{@link Integer }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link Integer }{@code >}
     * 
     * 
     */
    public List<JAXBElement<? extends Serializable>> getApplCodeOrAcctNbrOrOwnerCIFNbr() {
        if (applCodeOrAcctNbrOrOwnerCIFNbr == null) {
            applCodeOrAcctNbrOrOwnerCIFNbr = new ArrayList<JAXBElement<? extends Serializable>>();
        }
        return this.applCodeOrAcctNbrOrOwnerCIFNbr;
    }

}
