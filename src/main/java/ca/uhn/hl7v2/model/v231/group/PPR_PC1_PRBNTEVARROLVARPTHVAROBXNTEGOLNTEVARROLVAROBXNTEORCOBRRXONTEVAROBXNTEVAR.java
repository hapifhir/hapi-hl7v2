package ca.uhn.hl7v2.model.v231.group;

import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.log.HapiLogFactory;
import ca.uhn.hl7v2.model.v231.segment.*;

import ca.uhn.hl7v2.model.*;
/**
 * <p>Represents the PPR_PC1_PRBNTEVARROLVARPTHVAROBXNTEGOLNTEVARROLVAROBXNTEORCOBRRXONTEVAROBXNTEVAR Group.  A Group is an ordered collection of message 
 * segments that can repeat together or be optionally in/excluded together.
 * This Group contains the following elements: </p>
 * 0: PRB (Problem Detail) <b></b><br>
 * 1: NTE (NTE - notes and comments segment) <b>optional repeating</b><br>
 * 2: VAR (Variance) <b>optional repeating</b><br>
 * 3: PPR_PC1_ROLVAR (a Group object) <b>optional repeating</b><br>
 * 4: PPR_PC1_PTHVAR (a Group object) <b>optional repeating</b><br>
 * 5: PPR_PC1_OBXNTE (a Group object) <b>optional repeating</b><br>
 * 6: PPR_PC1_GOLNTEVARROLVAROBXNTE (a Group object) <b>optional repeating</b><br>
 * 7: PPR_PC1_ORCOBRRXONTEVAROBXNTEVAR (a Group object) <b>optional repeating</b><br>
 */
public class PPR_PC1_PRBNTEVARROLVARPTHVAROBXNTEGOLNTEVARROLVAROBXNTEORCOBRRXONTEVAROBXNTEVAR extends AbstractGroup {

	/** 
	 * Creates a new PPR_PC1_PRBNTEVARROLVARPTHVAROBXNTEGOLNTEVARROLVAROBXNTEORCOBRRXONTEVAROBXNTEVAR Group.
	 */
	public PPR_PC1_PRBNTEVARROLVARPTHVAROBXNTEGOLNTEVARROLVAROBXNTEORCOBRRXONTEVAROBXNTEVAR(Group parent, ModelClassFactory factory) {
	   super(parent, factory);
	   try {
	      this.add(PRB.class, true, false);
	      this.add(NTE.class, false, true);
	      this.add(VAR.class, false, true);
	      this.add(PPR_PC1_ROLVAR.class, false, true);
	      this.add(PPR_PC1_PTHVAR.class, false, true);
	      this.add(PPR_PC1_OBXNTE.class, false, true);
	      this.add(PPR_PC1_GOLNTEVARROLVAROBXNTE.class, false, true);
	      this.add(PPR_PC1_ORCOBRRXONTEVAROBXNTEVAR.class, false, true);
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error creating PPR_PC1_PRBNTEVARROLVARPTHVAROBXNTEGOLNTEVARROLVAROBXNTEORCOBRRXONTEVAROBXNTEVAR - this is probably a bug in the source code generator.", e);
	   }
	}

	/**
	 * Returns PRB (Problem Detail) - creates it if necessary
	 */
	public PRB getPRB() { 
	   PRB ret = null;
	   try {
	      ret = (PRB)this.get("PRB");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns  first repetition of NTE (NTE - notes and comments segment) - creates it if necessary
	 */
	public NTE getNTE() { 
	   NTE ret = null;
	   try {
	      ret = (NTE)this.get("NTE");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns a specific repetition of NTE
	 * (NTE - notes and comments segment) - creates it if necessary
	 * throws HL7Exception if the repetition requested is more than one 
	 *     greater than the number of existing repetitions.
	 */
	public NTE getNTE(int rep) throws HL7Exception { 
	   return (NTE)this.get("NTE", rep);
	}

	/** 
	 * Returns the number of existing repetitions of NTE 
	 */ 
	public int getNTEReps() { 
	    int reps = -1; 
	    try { 
	        reps = this.getAll("NTE").length; 
	    } catch (HL7Exception e) { 
	        String message = "Unexpected error accessing data - this is probably a bug in the source code generator."; 
	        HapiLogFactory.getHapiLog(this.getClass()).error(message, e); 
	        throw new RuntimeException(message);
	    } 
	    return reps; 
	} 

	/**
	 * Returns  first repetition of VAR (Variance) - creates it if necessary
	 */
	public VAR getVAR() { 
	   VAR ret = null;
	   try {
	      ret = (VAR)this.get("VAR");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns a specific repetition of VAR
	 * (Variance) - creates it if necessary
	 * throws HL7Exception if the repetition requested is more than one 
	 *     greater than the number of existing repetitions.
	 */
	public VAR getVAR(int rep) throws HL7Exception { 
	   return (VAR)this.get("VAR", rep);
	}

	/** 
	 * Returns the number of existing repetitions of VAR 
	 */ 
	public int getVARReps() { 
	    int reps = -1; 
	    try { 
	        reps = this.getAll("VAR").length; 
	    } catch (HL7Exception e) { 
	        String message = "Unexpected error accessing data - this is probably a bug in the source code generator."; 
	        HapiLogFactory.getHapiLog(this.getClass()).error(message, e); 
	        throw new RuntimeException(message);
	    } 
	    return reps; 
	} 

	/**
	 * Returns  first repetition of PPR_PC1_ROLVAR (a Group object) - creates it if necessary
	 */
	public PPR_PC1_ROLVAR getROLVAR() { 
	   PPR_PC1_ROLVAR ret = null;
	   try {
	      ret = (PPR_PC1_ROLVAR)this.get("ROLVAR");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns a specific repetition of PPR_PC1_ROLVAR
	 * (a Group object) - creates it if necessary
	 * throws HL7Exception if the repetition requested is more than one 
	 *     greater than the number of existing repetitions.
	 */
	public PPR_PC1_ROLVAR getROLVAR(int rep) throws HL7Exception { 
	   return (PPR_PC1_ROLVAR)this.get("ROLVAR", rep);
	}

	/** 
	 * Returns the number of existing repetitions of PPR_PC1_ROLVAR 
	 */ 
	public int getROLVARReps() { 
	    int reps = -1; 
	    try { 
	        reps = this.getAll("ROLVAR").length; 
	    } catch (HL7Exception e) { 
	        String message = "Unexpected error accessing data - this is probably a bug in the source code generator."; 
	        HapiLogFactory.getHapiLog(this.getClass()).error(message, e); 
	        throw new RuntimeException(message);
	    } 
	    return reps; 
	} 

	/**
	 * Returns  first repetition of PPR_PC1_PTHVAR (a Group object) - creates it if necessary
	 */
	public PPR_PC1_PTHVAR getPTHVAR() { 
	   PPR_PC1_PTHVAR ret = null;
	   try {
	      ret = (PPR_PC1_PTHVAR)this.get("PTHVAR");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns a specific repetition of PPR_PC1_PTHVAR
	 * (a Group object) - creates it if necessary
	 * throws HL7Exception if the repetition requested is more than one 
	 *     greater than the number of existing repetitions.
	 */
	public PPR_PC1_PTHVAR getPTHVAR(int rep) throws HL7Exception { 
	   return (PPR_PC1_PTHVAR)this.get("PTHVAR", rep);
	}

	/** 
	 * Returns the number of existing repetitions of PPR_PC1_PTHVAR 
	 */ 
	public int getPTHVARReps() { 
	    int reps = -1; 
	    try { 
	        reps = this.getAll("PTHVAR").length; 
	    } catch (HL7Exception e) { 
	        String message = "Unexpected error accessing data - this is probably a bug in the source code generator."; 
	        HapiLogFactory.getHapiLog(this.getClass()).error(message, e); 
	        throw new RuntimeException(message);
	    } 
	    return reps; 
	} 

	/**
	 * Returns  first repetition of PPR_PC1_OBXNTE (a Group object) - creates it if necessary
	 */
	public PPR_PC1_OBXNTE getOBXNTE() { 
	   PPR_PC1_OBXNTE ret = null;
	   try {
	      ret = (PPR_PC1_OBXNTE)this.get("OBXNTE");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns a specific repetition of PPR_PC1_OBXNTE
	 * (a Group object) - creates it if necessary
	 * throws HL7Exception if the repetition requested is more than one 
	 *     greater than the number of existing repetitions.
	 */
	public PPR_PC1_OBXNTE getOBXNTE(int rep) throws HL7Exception { 
	   return (PPR_PC1_OBXNTE)this.get("OBXNTE", rep);
	}

	/** 
	 * Returns the number of existing repetitions of PPR_PC1_OBXNTE 
	 */ 
	public int getOBXNTEReps() { 
	    int reps = -1; 
	    try { 
	        reps = this.getAll("OBXNTE").length; 
	    } catch (HL7Exception e) { 
	        String message = "Unexpected error accessing data - this is probably a bug in the source code generator."; 
	        HapiLogFactory.getHapiLog(this.getClass()).error(message, e); 
	        throw new RuntimeException(message);
	    } 
	    return reps; 
	} 

	/**
	 * Returns  first repetition of PPR_PC1_GOLNTEVARROLVAROBXNTE (a Group object) - creates it if necessary
	 */
	public PPR_PC1_GOLNTEVARROLVAROBXNTE getGOLNTEVARROLVAROBXNTE() { 
	   PPR_PC1_GOLNTEVARROLVAROBXNTE ret = null;
	   try {
	      ret = (PPR_PC1_GOLNTEVARROLVAROBXNTE)this.get("GOLNTEVARROLVAROBXNTE");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns a specific repetition of PPR_PC1_GOLNTEVARROLVAROBXNTE
	 * (a Group object) - creates it if necessary
	 * throws HL7Exception if the repetition requested is more than one 
	 *     greater than the number of existing repetitions.
	 */
	public PPR_PC1_GOLNTEVARROLVAROBXNTE getGOLNTEVARROLVAROBXNTE(int rep) throws HL7Exception { 
	   return (PPR_PC1_GOLNTEVARROLVAROBXNTE)this.get("GOLNTEVARROLVAROBXNTE", rep);
	}

	/** 
	 * Returns the number of existing repetitions of PPR_PC1_GOLNTEVARROLVAROBXNTE 
	 */ 
	public int getGOLNTEVARROLVAROBXNTEReps() { 
	    int reps = -1; 
	    try { 
	        reps = this.getAll("GOLNTEVARROLVAROBXNTE").length; 
	    } catch (HL7Exception e) { 
	        String message = "Unexpected error accessing data - this is probably a bug in the source code generator."; 
	        HapiLogFactory.getHapiLog(this.getClass()).error(message, e); 
	        throw new RuntimeException(message);
	    } 
	    return reps; 
	} 

	/**
	 * Returns  first repetition of PPR_PC1_ORCOBRRXONTEVAROBXNTEVAR (a Group object) - creates it if necessary
	 */
	public PPR_PC1_ORCOBRRXONTEVAROBXNTEVAR getORCOBRRXONTEVAROBXNTEVAR() { 
	   PPR_PC1_ORCOBRRXONTEVAROBXNTEVAR ret = null;
	   try {
	      ret = (PPR_PC1_ORCOBRRXONTEVAROBXNTEVAR)this.get("ORCOBRRXONTEVAROBXNTEVAR");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns a specific repetition of PPR_PC1_ORCOBRRXONTEVAROBXNTEVAR
	 * (a Group object) - creates it if necessary
	 * throws HL7Exception if the repetition requested is more than one 
	 *     greater than the number of existing repetitions.
	 */
	public PPR_PC1_ORCOBRRXONTEVAROBXNTEVAR getORCOBRRXONTEVAROBXNTEVAR(int rep) throws HL7Exception { 
	   return (PPR_PC1_ORCOBRRXONTEVAROBXNTEVAR)this.get("ORCOBRRXONTEVAROBXNTEVAR", rep);
	}

	/** 
	 * Returns the number of existing repetitions of PPR_PC1_ORCOBRRXONTEVAROBXNTEVAR 
	 */ 
	public int getORCOBRRXONTEVAROBXNTEVARReps() { 
	    int reps = -1; 
	    try { 
	        reps = this.getAll("ORCOBRRXONTEVAROBXNTEVAR").length; 
	    } catch (HL7Exception e) { 
	        String message = "Unexpected error accessing data - this is probably a bug in the source code generator."; 
	        HapiLogFactory.getHapiLog(this.getClass()).error(message, e); 
	        throw new RuntimeException(message);
	    } 
	    return reps; 
	} 

}
