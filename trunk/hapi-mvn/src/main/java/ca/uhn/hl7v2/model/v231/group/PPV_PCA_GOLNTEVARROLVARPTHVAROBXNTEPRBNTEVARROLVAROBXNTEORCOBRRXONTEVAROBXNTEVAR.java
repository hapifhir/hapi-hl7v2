package ca.uhn.hl7v2.model.v231.group;

import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.log.HapiLogFactory;
import ca.uhn.hl7v2.model.v231.segment.*;

import ca.uhn.hl7v2.model.*;
/**
 * <p>Represents the PPV_PCA_GOLNTEVARROLVARPTHVAROBXNTEPRBNTEVARROLVAROBXNTEORCOBRRXONTEVAROBXNTEVAR Group.  A Group is an ordered collection of message 
 * segments that can repeat together or be optionally in/excluded together.
 * This Group contains the following elements: </p>
 * 0: GOL (Goal Detail) <b></b><br>
 * 1: NTE (NTE - notes and comments segment) <b>optional repeating</b><br>
 * 2: VAR (Variance) <b>optional repeating</b><br>
 * 3: PPV_PCA_ROLVAR (a Group object) <b>optional repeating</b><br>
 * 4: PPV_PCA_PTHVAR (a Group object) <b>optional repeating</b><br>
 * 5: PPV_PCA_OBXNTE (a Group object) <b>optional repeating</b><br>
 * 6: PPV_PCA_PRBNTEVARROLVAROBXNTE (a Group object) <b>optional repeating</b><br>
 * 7: PPV_PCA_ORCOBRRXONTEVAROBXNTEVAR (a Group object) <b>optional repeating</b><br>
 */
public class PPV_PCA_GOLNTEVARROLVARPTHVAROBXNTEPRBNTEVARROLVAROBXNTEORCOBRRXONTEVAROBXNTEVAR extends AbstractGroup {

	/** 
	 * Creates a new PPV_PCA_GOLNTEVARROLVARPTHVAROBXNTEPRBNTEVARROLVAROBXNTEORCOBRRXONTEVAROBXNTEVAR Group.
	 */
	public PPV_PCA_GOLNTEVARROLVARPTHVAROBXNTEPRBNTEVARROLVAROBXNTEORCOBRRXONTEVAROBXNTEVAR(Group parent, ModelClassFactory factory) {
	   super(parent, factory);
	   try {
	      this.add(GOL.class, true, false);
	      this.add(NTE.class, false, true);
	      this.add(VAR.class, false, true);
	      this.add(PPV_PCA_ROLVAR.class, false, true);
	      this.add(PPV_PCA_PTHVAR.class, false, true);
	      this.add(PPV_PCA_OBXNTE.class, false, true);
	      this.add(PPV_PCA_PRBNTEVARROLVAROBXNTE.class, false, true);
	      this.add(PPV_PCA_ORCOBRRXONTEVAROBXNTEVAR.class, false, true);
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error creating PPV_PCA_GOLNTEVARROLVARPTHVAROBXNTEPRBNTEVARROLVAROBXNTEORCOBRRXONTEVAROBXNTEVAR - this is probably a bug in the source code generator.", e);
	   }
	}

	/**
	 * Returns GOL (Goal Detail) - creates it if necessary
	 */
	public GOL getGOL() { 
	   GOL ret = null;
	   try {
	      ret = (GOL)this.get("GOL");
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
	 * Returns  first repetition of PPV_PCA_ROLVAR (a Group object) - creates it if necessary
	 */
	public PPV_PCA_ROLVAR getROLVAR() { 
	   PPV_PCA_ROLVAR ret = null;
	   try {
	      ret = (PPV_PCA_ROLVAR)this.get("ROLVAR");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns a specific repetition of PPV_PCA_ROLVAR
	 * (a Group object) - creates it if necessary
	 * throws HL7Exception if the repetition requested is more than one 
	 *     greater than the number of existing repetitions.
	 */
	public PPV_PCA_ROLVAR getROLVAR(int rep) throws HL7Exception { 
	   return (PPV_PCA_ROLVAR)this.get("ROLVAR", rep);
	}

	/** 
	 * Returns the number of existing repetitions of PPV_PCA_ROLVAR 
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
	 * Returns  first repetition of PPV_PCA_PTHVAR (a Group object) - creates it if necessary
	 */
	public PPV_PCA_PTHVAR getPTHVAR() { 
	   PPV_PCA_PTHVAR ret = null;
	   try {
	      ret = (PPV_PCA_PTHVAR)this.get("PTHVAR");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns a specific repetition of PPV_PCA_PTHVAR
	 * (a Group object) - creates it if necessary
	 * throws HL7Exception if the repetition requested is more than one 
	 *     greater than the number of existing repetitions.
	 */
	public PPV_PCA_PTHVAR getPTHVAR(int rep) throws HL7Exception { 
	   return (PPV_PCA_PTHVAR)this.get("PTHVAR", rep);
	}

	/** 
	 * Returns the number of existing repetitions of PPV_PCA_PTHVAR 
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
	 * Returns  first repetition of PPV_PCA_OBXNTE (a Group object) - creates it if necessary
	 */
	public PPV_PCA_OBXNTE getOBXNTE() { 
	   PPV_PCA_OBXNTE ret = null;
	   try {
	      ret = (PPV_PCA_OBXNTE)this.get("OBXNTE");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns a specific repetition of PPV_PCA_OBXNTE
	 * (a Group object) - creates it if necessary
	 * throws HL7Exception if the repetition requested is more than one 
	 *     greater than the number of existing repetitions.
	 */
	public PPV_PCA_OBXNTE getOBXNTE(int rep) throws HL7Exception { 
	   return (PPV_PCA_OBXNTE)this.get("OBXNTE", rep);
	}

	/** 
	 * Returns the number of existing repetitions of PPV_PCA_OBXNTE 
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
	 * Returns  first repetition of PPV_PCA_PRBNTEVARROLVAROBXNTE (a Group object) - creates it if necessary
	 */
	public PPV_PCA_PRBNTEVARROLVAROBXNTE getPRBNTEVARROLVAROBXNTE() { 
	   PPV_PCA_PRBNTEVARROLVAROBXNTE ret = null;
	   try {
	      ret = (PPV_PCA_PRBNTEVARROLVAROBXNTE)this.get("PRBNTEVARROLVAROBXNTE");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns a specific repetition of PPV_PCA_PRBNTEVARROLVAROBXNTE
	 * (a Group object) - creates it if necessary
	 * throws HL7Exception if the repetition requested is more than one 
	 *     greater than the number of existing repetitions.
	 */
	public PPV_PCA_PRBNTEVARROLVAROBXNTE getPRBNTEVARROLVAROBXNTE(int rep) throws HL7Exception { 
	   return (PPV_PCA_PRBNTEVARROLVAROBXNTE)this.get("PRBNTEVARROLVAROBXNTE", rep);
	}

	/** 
	 * Returns the number of existing repetitions of PPV_PCA_PRBNTEVARROLVAROBXNTE 
	 */ 
	public int getPRBNTEVARROLVAROBXNTEReps() { 
	    int reps = -1; 
	    try { 
	        reps = this.getAll("PRBNTEVARROLVAROBXNTE").length; 
	    } catch (HL7Exception e) { 
	        String message = "Unexpected error accessing data - this is probably a bug in the source code generator."; 
	        HapiLogFactory.getHapiLog(this.getClass()).error(message, e); 
	        throw new RuntimeException(message);
	    } 
	    return reps; 
	} 

	/**
	 * Returns  first repetition of PPV_PCA_ORCOBRRXONTEVAROBXNTEVAR (a Group object) - creates it if necessary
	 */
	public PPV_PCA_ORCOBRRXONTEVAROBXNTEVAR getORCOBRRXONTEVAROBXNTEVAR() { 
	   PPV_PCA_ORCOBRRXONTEVAROBXNTEVAR ret = null;
	   try {
	      ret = (PPV_PCA_ORCOBRRXONTEVAROBXNTEVAR)this.get("ORCOBRRXONTEVAROBXNTEVAR");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns a specific repetition of PPV_PCA_ORCOBRRXONTEVAROBXNTEVAR
	 * (a Group object) - creates it if necessary
	 * throws HL7Exception if the repetition requested is more than one 
	 *     greater than the number of existing repetitions.
	 */
	public PPV_PCA_ORCOBRRXONTEVAROBXNTEVAR getORCOBRRXONTEVAROBXNTEVAR(int rep) throws HL7Exception { 
	   return (PPV_PCA_ORCOBRRXONTEVAROBXNTEVAR)this.get("ORCOBRRXONTEVAROBXNTEVAR", rep);
	}

	/** 
	 * Returns the number of existing repetitions of PPV_PCA_ORCOBRRXONTEVAROBXNTEVAR 
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
