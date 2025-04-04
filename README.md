# Secure-File-Transmission-Using-Public-Key-Encryption
The main perspective of the project is to communicate the file with other system or user  more securely from the third party attack. Here, the sender takes the at most care from unauthorized view and unauthorized modification of the file, i.e the main concept in this project 
is to provide confidentiality and integrity for file transmission.

 The Project is designed to transmit the file in the following two ways 
 
	Case (1) Peer to peer (Directly from source to destination in smaller networks (LAN) 
	Case (2) Sharing the file via routers in larger networks. (Having multiple routers in the 
	path between the source and destination)  
	              
             
In case 1, the chances of attack is very less or maybe almost zero, since the sender and 
receivers are communicating directly through signal media. Extracting the information from 
the media is much more difficult. 
In case 2, the probability or percentage of attack is high. This may be due to involving 
third parties (i.e routers) for transmission of file. On contrast to case 1, the attackers may exploit 
this third party usage in transmission to extract or unauthorized access to the information. Thus 
it is required to implement the security measures for case 2, scenario. 

  The main coverage in this project involves 
  
          ❖ Preventing attacker from unauthorized access at router level or restriction 
          of unauthorized access. 
          ❖ Identifying the modification of the contents by the attacker, this enabling 
          the receiver to reject the modified information. 
          ❖ Implementing the transfer of file contents in the form of packets. 
          ❖ Implementing the operation of the router in simplified manner. 
          ❖ Demonstrating the process of attack at the router.

  As the name of the project, the data encryption is achieved by using public key 
encryption algorithm. Here, the most popular public key encryption algorithm RSA is 
implemented in the project to mask the information. 

The RSA algorithm is implemented with the following restriction in the project.

	❖ Uses two digits prime number. 
	❖ ‘e’ and ‘d’ are calculated as per the RSA algorithm specification. 
	❖ RSA algorithm is implemented to read the plain text only from the text file. 
	❖ RSA algorithm writes the encrypted data back to the file. 
	❖ RSA encryption algorithm is implemented at the sender side. 
	❖ RSA decryption algorithm is implemented at the receiver side. 

Identifying the modification of contents (Data Integrity) 

	Apart from the unauthorized access, the attacker may alter, or destroy the information. 
	Hence it is essential for the receiver to know about this modification by an attacker. Generally 
	in cyber security context, this modification is identified by using a special code, namely 
	Message Authentication Code(MAC). Generation of this MAC for the information is done by 
	the sender using MAC generation algorithm. Simple MAC generation algorithm is 
	implemented in this project to aid the receiver know false information transmission. 
	The MAC algorithm implemented in the project reads the contents of the file character 
	by character, Performs the summation of each ASCII value of the character. The final MAC 
	code is the sum of all the characters in the file. The MAC algorithm is designed and 
	implemented at both sender and receiver. The sender uses the MAC algorithm for generating 
	the MAC code attaching it to the information. The receiver uses the MAC algorithm, to 
	generate as well as for data verification. This MAC code is transmitted as the part of the 
	information to the receiver. 

Transfer of file contents in the form of Packet 

	As we know, any information transmission across the network takes place in the form 
	of packets. Here, the contents of the file is also transmitted in the form of packets. The packet 
	is implemented as a file, by dividing the records of the file as packet fields. 
	
	The First 100 bytes of the file is treated as the fields containing the actual message, the 
	next four bytes to carry MAC code, the next four bytes to carry source and destination address. 
 
Implementation the operation of the router 

	The file is securely transferred from the source to destination via router. When source 
	transfer the file, by default it travels to router. On order to forward the packet, the router reads 
	the destination address from the packet and forwards it to the destination system. 

Implementation of attacker operation 

	Demonstration of the attack operation is implemented at the router level. A prevision is 
	made at the router for the attacker to access the file. Here, the attacker will tries to modifies the 
	contents of the file and the same is verified at the destination system with the help of MAC 
	code 
 
Hardware Requirements 

	➢ System :12th Gen Intel(R) Core(TM) i5-1235U   1.30 GHz. 
	➢ Hard Disk : 40 GB. 
	➢ Monitor : 15 VGA Color.
	➢ Mouse  : Logitech. 
	➢ RAM  : 256 MB.
	➢ LAN Switch  : D-Link. 
	➢ LAN Cable : CAT6 Cable. 
 
Software Requirements 

➢ Operating System : Windows 10/11.
➢ Coding Language : Java. 
➢ Tool Used  : Visual Studio Code.
 
The Java Programming Language 

	In the Java programming language, all source code is first written in plain text files 
	ending with the .java extension. Those source files are then compiled into .class files by 
	the javac compiler. A .class file does not contain code that is native to your processor; it 
	instead contains bytecodes — the machine language of the Java Virtual Machine(Java VM). 
	The java launcher tool then runs your application with an instance of the Java Virtual 
	Machine.
 
<img width="461" alt="{D30867CC-5E8F-42DC-ADC2-D5E84ED93125}" src="https://github.com/user-attachments/assets/a1bf15b0-757e-4a98-8eef-0e98d25611fe" />

  	Because the Java VM is available on many different operating systems, the same .class files 
	are capable of running on Microsoft Windows, the Solaris Operating System (Solaris OS), 
	Linux, or Mac OS. Some virtual machines, such as the Java SE HotSpot at a Glance, perform 
	additional steps at runtime to give your application a performance boost. This includesvarious 
	tasks such as finding performance bottlenecks and recompiling (to native code) frequently used 
	sections of code. 

 <img width="278" alt="{DE490697-30F6-4454-B528-4D64DC32D91B}" src="https://github.com/user-attachments/assets/630f05a2-f15f-4575-b554-292aad599abe" />
 
  Data Flow Diagram 

  <img width="258" alt="{4274A5BB-CFE4-4771-B82A-7FA3689DB2E7}" src="https://github.com/user-attachments/assets/c23e6c19-7c51-4d19-b728-b1c22e148471" />


REFERENCES

Books:

	1. Java Handbook by Patrick Naughton. 
	2. Java The Complete Reference Eighth Edition by Herbert Schildt. 
	3. CORE JAVA Book by Cay S. Horstmann and Gary Cornell 
 
Websites: 

	1. Socket Programming in Java - GeeksforGeeks or 
	https://www.geeksforgeeks.org/socket-programming-in-java/ 
	2. Java JTextArea - javatpoint or https://www.javatpoint.com/java-jtextarea 
	3. RandomAccessFile (Java Platform SE 8 ) (oracle.com) or 
	https://docs.oracle.com/javase/8/docs/api/java/io/RandomAccessFile.html 
	4. SWING - JButton Class (tutorialspoint.com) or 
	https://www.tutorialspoint.com/swing/swing_jbutton.html
 
You Tube channels: 

	1. File transfer program in java using TCP made Simple (youtube.com) or 
	https://www.youtube.com/watch?v=WeaB8pAGlDw 
	2. Transfer File From Client To Server Using Java Socket Programming in 
	Localhost - D4 Learner (youtube.com)  or 
	https://www.youtube.com/watch?v=vsWoSpQ6Dww 
	3. Custom Encryption And Decryption In Java (youtube.com) or 
	https://www.youtube.com/watch?v=SyIf9fMXCz0 
	4. Java GUI: Full Course ☕ (FREE) (youtube.com) or 
	https://www.youtube.com/watch?v=Kmgo00avvEw 
	5. Connect computers using Java programs and networking (youtube.com) or 
	https://www.youtube.com/watch?v=4r4qm_Zxnik 
	6. Message Dialog Box (Popup) in JAVA SWING GUI Program | JOptionPane 
	showMessageDialog examples (youtube.com) or 
	https://www.youtube.com/watch?v=_hB94F8JioM 
	7. #48 Java Swing Tutorial | JDialog in Java (youtube.com) or 
	https://www.youtube.com/watch?v=nMe9fAUfTBE&t=539s

 

