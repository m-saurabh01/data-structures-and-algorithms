package BitManipulation;

/*
 * 				Leetcode 2220 Minimum Bit Flips to Convert Number Medium
 * 
A bit flip of a number x is choosing a bit in the binary representation of x and flipping it from either 0 to 1 or 1 to 0.

For example, for x = 7, the binary representation is 111 and we may choose any bit (including any leading zeros not shown) and flip it. We can flip the first bit from the right to get 110, flip the second bit from the right to get 101, flip the fifth bit from the right (a leading zero) to get 10111, etc.
Given two integers start and goal, return the minimum number of bit flips to convert start to goal.

 

Example 1:

Input: start = 10, goal = 7
Output: 3
Explanation: The binary representation of 10 and 7 are 1010 and 0111 respectively. We can convert 10 to 7 in 3 steps:
- Flip the first bit from the right: 1010 -> 1011.
- Flip the third bit from the right: 1011 -> 1111.
- Flip the fourth bit from the right: 1111 -> 0111.
It can be shown we cannot convert 10 to 7 in less than 3 steps. Hence, we return 3.

Example 2:

Input: start = 3, goal = 4
Output: 3
Explanation: The binary representation of 3 and 4 are 011 and 100 respectively. We can convert 3 to 4 in 3 steps:
- Flip the first bit from the right: 011 -> 010.
- Flip the second bit from the right: 010 -> 000.
- Flip the third bit from the right: 000 -> 100.
It can be shown we cannot convert 3 to 4 in less than 3 steps. Hence, we return 3.

*/
public class MinBitFlipToConvertNum {
	
	 public int minBitFlips(int st, int gl) {

	        int res=0;

	        while(st>0||gl>0){
	            int sg=st&1;
	            int gg=gl&1;

	            res+=(sg!=gg)?1:0;

	            st=st>0?st>>1:0;
	            gl=gl>0?gl>>1:0;
	        }

	        return res;


	    }

}

/*
 * 
 * # 💫 About Me: I'm a dedicated software developer with a strong foundation in
 * Spring Boot, Microservices, React, and Angular. My focus lies in creating
 * efficient and scalable solutions that meet the demands of modern
 * applications.<br><br>I'm actively seeking opportunities to collaborate on
 * microservice and cloud-based backend and frontend projects. My expertise
 * allows me to contribute significantly to the development and deployment of
 * robust and scalable systems.<br><br>I'm currently looking for help with
 * mid-scale deliverable projects to further hone my skills and gain practical
 * experience. I'm eager to work alongside experienced professionals to learn
 * and contribute to successful project outcomes.<br><br>In addition to my
 * current skills, I'm continuously expanding my knowledge by learning React,
 * Node.js Express, and SpringBoot Microservices. These technologies are
 * essential for building modern, dynamic, and efficient applications.
 * 
 * 
 * ## 🌐 Socials:
 * [![LinkedIn](https://img.shields.io/badge/LinkedIn-%230077B5.svg?logo=
 * linkedin&logoColor=white)](https://linkedin.com/in/er-saurabh)
 * 
 * # 💻 Tech Stack:
 * ![CSS3](https://img.shields.io/badge/css3-%231572B6.svg?style=for-the-badge&
 * logo=css3&logoColor=white)
 * ![HTML5](https://img.shields.io/badge/html5-%23E34F26.svg?style=for-the-badge
 * &logo=html5&logoColor=white)
 * ![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&
 * logo=openjdk&logoColor=white)
 * ![JavaScript](https://img.shields.io/badge/javascript-%23323330.svg?style=for
 * -the-badge&logo=javascript&logoColor=%23F7DF1E)
 * ![AWS](https://img.shields.io/badge/AWS-%23FF9900.svg?style=for-the-badge&
 * logo=amazon-aws&logoColor=white) ![Google
 * Cloud](https://img.shields.io/badge/GoogleCloud-%234285F4.svg?style=for-the-
 * badge&logo=google-cloud&logoColor=white)
 * ![GithubPages](https://img.shields.io/badge/github%20pages-121013?style=for-
 * the-badge&logo=github&logoColor=white)
 * ![Angular](https://img.shields.io/badge/angular-%23DD0031.svg?style=for-the-
 * badge&logo=angular&logoColor=white) ![Apache
 * Kafka](https://img.shields.io/badge/Apache%20Kafka-000?style=for-the-badge&
 * logo=apachekafka)
 * ![Bootstrap](https://img.shields.io/badge/bootstrap-%238511FA.svg?style=for-
 * the-badge&logo=bootstrap&logoColor=white)
 * ![Express.js](https://img.shields.io/badge/express.js-%23404d59.svg?style=for
 * -the-badge&logo=express&logoColor=%2361DAFB)
 * ![NodeJS](https://img.shields.io/badge/node.js-6DA55F?style=for-the-badge&
 * logo=node.js&logoColor=white)
 * ![Nodemon](https://img.shields.io/badge/NODEMON-%23323330.svg?style=for-the-
 * badge&logo=nodemon&logoColor=%BBDEAD)
 * ![NPM](https://img.shields.io/badge/NPM-%23CB3837.svg?style=for-the-badge&
 * logo=npm&logoColor=white)
 * ![React](https://img.shields.io/badge/react-%2320232a.svg?style=for-the-badge
 * &logo=react&logoColor=%2361DAFB)
 * ![Apache](https://img.shields.io/badge/apache-%23D42029.svg?style=for-the-
 * badge&logo=apache&logoColor=white) ![Apache
 * Maven](https://img.shields.io/badge/Apache%20Maven-C71A36?style=for-the-badge
 * &logo=Apache%20Maven&logoColor=white) ![Apache
 * Tomcat](https://img.shields.io/badge/apache%20tomcat-%23F8DC75.svg?style=for-
 * the-badge&logo=apache-tomcat&logoColor=black)
 * ![Jenkins](https://img.shields.io/badge/jenkins-%232C5263.svg?style=for-the-
 * badge&logo=jenkins&logoColor=white)
 * ![MySQL](https://img.shields.io/badge/mysql-4479A1.svg?style=for-the-badge&
 * logo=mysql&logoColor=white)
 * ![Postgres](https://img.shields.io/badge/postgres-%23316192.svg?style=for-the
 * -badge&logo=postgresql&logoColor=white)
 * ![MongoDB](https://img.shields.io/badge/MongoDB-%234ea94b.svg?style=for-the-
 * badge&logo=mongodb&logoColor=white)
 * ![Hibernate](https://img.shields.io/badge/Hibernate-59666C?style=for-the-
 * badge&logo=Hibernate&logoColor=white)
 * ![Canva](https://img.shields.io/badge/Canva-%2300C4CC.svg?style=for-the-badge
 * &logo=Canva&logoColor=white)
 * ![Figma](https://img.shields.io/badge/figma-%23F24E1E.svg?style=for-the-badge
 * &logo=figma&logoColor=white)
 * ![Git](https://img.shields.io/badge/git-%23F05033.svg?style=for-the-badge&
 * logo=git&logoColor=white)
 * ![Gitea](https://img.shields.io/badge/Gitea-34495E?style=for-the-badge&logo=
 * gitea&logoColor=5D9425)
 * ![GitHub](https://img.shields.io/badge/github-%23121011.svg?style=for-the-
 * badge&logo=github&logoColor=white) # 📊 GitHub Stats:
 * ![](https://github-readme-stats.vercel.app/api?username=m-saurabh01&theme=
 * dark&hide_border=false&include_all_commits=false&count_private=false)<br/>
 * ![](https://github-readme-streak-stats.herokuapp.com/?user=m-saurabh01&theme=
 * dark&hide_border=false)<br/>
 * ![](https://github-readme-stats.vercel.app/api/top-langs/?username=m-
 * saurabh01&theme=dark&hide_border=false&include_all_commits=false&
 * count_private=false&layout=compact)
 * 
 * ---
 * [![](https://visitcount.itsvg.in/api?id=m-saurabh01&icon=0&color=0)](https://
 * visitcount.itsvg.in)
 */
