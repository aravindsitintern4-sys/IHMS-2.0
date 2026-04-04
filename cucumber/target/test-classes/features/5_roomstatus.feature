#@login @dashboard @outpatientmaster
@roomstatusmaster
Feature: Room Status Management

Background:
  Given user is on dashboard group landing page
  When user clicks on Current Room Status
  Then user should be navigated to Room Master page

# PATIENT TYPE VALIDATION                        
Scenario Outline: Patient Type field validation
  And user selects Patient Type "<patientType>"
  Then room Type dropdown should display correct options 
    | roomType |
    | <option1> |
    | <option2> |
    | <option3> |
    | <option4> |
    | <option5> |
    | <option6> |
    | <option7> |
    | <option8> |
    | <option9> |
  Then save button should be disabled
  And user clicks on Clear button 

Examples:
  | patientType | option1  | option2  | option3 | option4  | option5  | option6  | option7  | option8  | option9  |
  | Pay         | A        | ASA      | B       | C        | D        | OP       | SUT      |          |          |
  | Free        | FREEDUMMY| FREEIOL  | FREEOP  | FREETYPE1| FREETYPE2| FREETYPE3| FREETYPE4| FREETYPE5| FREETYPE6|
  | Camp        | FREETYPE7|          |         |         |         |         |          |          |          |

# NEGATIVE CHECK FOR EMPTY FIELDS

Scenario Outline: Save button should be disabled when field is empty
  And user leaves room status "<field>" empty
  Then save button should be disabled
  
Examples:
  | field          |
  | Patient Type   |
  | Room Type      |
  | Room Number    |
  | Occupancy Flag |
  | Floor          |
  | Toilet Type    |
  | Location       |

# ROOM TYPE VALIDATION                           
Scenario Outline: Room Type field validation
  And user selects Patient Type "<patientType>"
  And user selects Room Type "<roomType>"
  Then save button should be disabled
  And user clicks on Clear button 

Examples:
  | patientType | roomType  |
  | Pay         | A         | 
  | Pay         | ASA       |
  | Free        | FREEDUMMY |
  | Free        | FREEOP    |
  | Camp        | FREETYPE7 |


# ROOM NUMBER VALIDATION                         
Scenario Outline: Room Number field validation
  And user enters Room No "<roomNo>"
  Then save button should be disabled
  And user clicks on Clear button 

Examples:
  | roomNo  |
  | 101     |
  | 202     |
  | ABC     |   
  |         | 
  
# OCCUPANCY FLAG VALIDATION                    
Scenario Outline: Occupancy Flag field validation
  And user selects Occupancy Flag "<occupancyFlag>"
  Then save button should be disabled
  And user clicks on Clear button 

Examples:
  | occupancyFlag |
  | OCCUPIED      |
  | FREE          |
  | VACCANT       |
  | BLOCKED       |

# FLOOR VALIDATION                              
Scenario Outline: Floor field validation
  And user selects Floor "<floor>"
  Then save button should be disabled
  And user clicks on Clear button 
 
Examples:
  | floor               |
  | NEW FIRST FLOOR     |
  | NEW SECOND FLOOR    |
  | FREE THIRD FLOOR    |

# TOILET TYPE VALIDATION            
Scenario Outline: Toilet Type field validation
  And user selects Toilet Type "<toiletType>"
  Then save button should be disabled
  And user clicks on Clear button 

Examples:
  | toiletType |
  | INDIAN     |
  | WESTERN    |
  | N/A        |


# LOCATION VALIDATION                
Scenario Outline: Location field validation
  And user selects Location "<location>"
  Then save button should be disabled
  And user clicks on Clear button 

Examples:
  | location           |
  | A-SCAN             |
  | BIOCHEMISTRY       |
  | CORNEA CLINIC      |

# FULL POSITIVE SCENARIO                          
Scenario Outline: Save Room Status Successfully
  And user selects Patient Type "<patientType>"
  And user selects Room Type "<roomType>"
  And user enters Room No "<roomNo>"
  And user selects Occupancy Flag "<occupancyFlag>"
  And user selects Floor "<floor>"
  And user selects Toilet Type "<toiletType>"
  And user selects Location "<location>"
  Then save button should be enabled
  When user clicks on Save button 
  Then room status should be saved successfully
  #When user clicks on Clear button 
  #Then all fields should be reset

Examples:
  | patientType | roomType  | roomNo | occupancyFlag | floor             | toiletType | location     |
  | Pay         | A         | 101    | OCCUPIED      | NEW FIRST FLOOR   | INDIAN     | A-SCAN       |
  | Free        | FREEDUMMY | 201    | FREE          | FREE SECOND FLOOR | N/A        | FREENEW      |
  | Camp        | FREETYPE7 | 301    | VACCANT       | NEW THIRD FLOOR   | WESTERN    | CORNEA CLINIC|
  
#SEARCH ROOM VALIDATION 

Scenario Outline: Search Room Number validation
  And user enters Room No in search "<roomNo>"
  Then room status search result should be displayed

Examples:
  | roomNo |
  | 101    |

Scenario Outline: Search Room Number negative validation
  And user enters Room No in search "<roomNo>"
  Then no room status result should be displayed

Examples:
  | roomNo |
  | ABC    |