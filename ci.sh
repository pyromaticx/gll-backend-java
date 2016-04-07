clear
echo "    #######  #######          #        ###  #           #  #######          #              #        #######  ####### "
echo "    #        #     #          #         #    #         #   #                #             # #       #     #  #       "
echo "    #        #     #          #         #     #       #    #                #            #   #      #     #  #       "
echo "    #  ####  #     #          #         #      #     #     #######          #           #######     ######   ####### "
echo "    #  #  #  #     #          #         #       #   #      #                #          #       #    #     #        # "
echo "    #  #  #  #     #          #         #        # #       #                #         #         #   #     #        # "
echo "    ####  #  #######          #######  ###        #        #######          #######  #           #  #######  ####### "
RED='\033[0;31m'
NC='\033[0m'

choice=""
message=""
echo "Where to run ? "
echo " "
echo "1. local machine "
echo "2. staging server "
echo "3. production server "
read choice;
if [ "$choice" = "1" ] 
then
        clear
        printf "${RED}Running on Local Server....${NC}\n"
        echo "${RED}Compling....${NC}\n"
        mvn clean install
        echo "${RED}Now Going To Run....${NC}\n"
        mvn tomcat7:run -P development
elif [ "$choice" = "2" ]
then
        clear
        mvn clean install
        mvn tomcat7:run -P test
elif [ "$choice" = "3" ]
then
        clear
        printf "${RED}[www.golivelabs.io] Running on Production Server....${NC}\n"
        echo "${RED} [ Go-Live-Labs ] Adding to GIT...${NC}\n"
        git add --all
        echo "${RED} Enter commit message...${NC} \n"
        read message
        echo "Commiting to GIT...."
        git commit -m $message

        # if you want to reset remote repo.
        #  rm -rf .git
        #  git init
        #  git add --all
        #  git commit -m 'first commit'
        #  git remote add origin https://github.com/Go-Live-Labs/hrboost.git
        #  git push -u origin master
        #  heroku login
        #  git remote -v
        #  heroku git:remote -a hrboost
        #  git remote add origin https://github.com/Go-Live-Labs/hrboost.git
        #  git push --force --set-upstream origin master

        echo -e "\033[33;5;7m Pushing to GIT [ Go-Live-Labs ] ... \033[0m"
        git push --force origin master
        
        echo "${RED} Determining hrboost application usage... ${NC}\n"
        heroku ps -a hrboost
        
        echo "${RED} Pushing to Heroku...${NC}"
        git push --force heroku master
        printf "${RED} Going to Start http://hrboost.herokuapp.com ...${NC}\n"
        heroku ps:scale web=1
        echo -e "\033[33;5;7m Opening Application in browser...\033[0m"
        heroku open
        echo -e "\033[33;5;7m Do you want to see logs? \033[0m"
        read choice
        if [ "$choice" = "y" ] 
        then
                echo "Echoing Log..."
                heroku logs --app hrboost
        else
                echo "Bye..."
        fi
fi


