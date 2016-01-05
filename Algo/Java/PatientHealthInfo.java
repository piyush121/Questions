public class PatientHealthInfo
{
	public static void main(String args[])
	{
		Patient p1 = new Patient();
		
	}
}

class Patient
{
	private String patientId;
	private String patientName;
	private Date patientDOB;

	private String caseId;
	private Date caseCreatedOn;

	private List<Allergy> allergyList;
	//private List<Disease> diseaseList;

	public String getPatientId()
	{
		return this.patientId;
	}

	public void setPatientId(String patientId)
	{
		this.patientId = patientId;
	}

	public String getPatientName()
	{
		return this.patientName;
	}

	public void setPatientName(String patientName)
	{
		this.patientName = patientName;
	}

	public void setPatientDOB(Date patientDOB)
	{
		this.patientDOB = patientDOB;
	}

	public Date getPatientDOB()
	{
		return this.patientDOB;
	}

	public String getCaseId()
	{
		return this.caseId;
	}

	public void setCaseId(String caseId)
	{
		this.caseId = caseId;
	}

	public Date getCaseCreatedOn()
	{
		return this.caseCreatedOn;
	}

	public void setCaseCreatedOn(Date caseCreatedOn)
	{
		this.caseCreatedOn = caseCreatedOn;
	}

	public void setAllergyList(List<Allergy> allergyList)
	{
		this.allergyList = allergyList;
	}

	public List<Allergy> getAllergyList()
	{
		return this.allergyList;
	}

	public boolean isAllergic()
	{
		if(this.getAllergyList.size()>0)
			return true;
		return false;
	}
}

class Allergy
{
	private String allergyName;
	private String description;
	private Level severity;
	private Date reportedOn;
	private String reportedByName;
	private String reportedById;

	public void setAllergyName(String allergyName)
	{
		this.allergyName = allergyName;
	}

	public String getAllergyName()
	{
		return this.allergyName;
	}

	public setDescription(String description)
	{
		this.description = description;
	}

	public String getDescription()
	{
		return this.description;
	}

	public void setSeverity(Level severity)
	{
		this.severity = severity;
	}

	public Level getSeverity()
	{
		return this.severity;
	}

	public void setReportedOn(Date reportedOn)
	{
		this.reportedOn = reportedOn;
	}

	public Date getReportedOn()
	{
		return this.reportedOn;
	}

	public String getReportedByName()
	{
		this.reportedByName;
	}

	public void setReportedByName(String reportedByName)
	{
		this.reportedByName = reportedByName;
	}

	public void setReportedById(String reoprtedById)
	{
		this.reportedById = reportedById;
	}

	public String getReoprtedById()
	{
		return this.reportedById;
	}
}

enum Level
{
	High(3),
	MEDIUM(2),
	LOW(1);

	private final int levelCode;

	private Level(int levelCode)
	{
		this.levelCode = levelCode;
	}
}