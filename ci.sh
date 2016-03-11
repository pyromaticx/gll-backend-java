clear
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
        mvn clean install
        mvn tomcat7:run -P development
elif [ "$choice" = "2" ]
then
        clear
        mvn clean install
        mvn tomcat7:run -P test
elif [ "$choice" = "3" ]
then
        clear
        echo "Adding to GIT..."
        git add .
        echo "Enter commit message... "
        read message
        echo "Commiting to GIT...."
        git commit -m $message

        # if you want to reset remote repo.
        #  rm -rf .git
        #  git init
        #  git add .
        #  git commit -m 'first commit'
        #  git remote add origin https://github.com/Go-Live-Labs/hrboost.git
        #  git push -u origin master
        #  heroku login
        #  git remote -v
        #  heroku git:remote -a hrboost
        #  git remote add origin https://github.com/Go-Live-Labs/hrboost.git
        #  git push --force --set-upstream origin master

        echo "Pushing to GIT..."
        git push -u origin master
        echo "Pushing to Heroku..."
        git push heroku master
        echo "Scaling Dyno..."
        heroku ps:scale web=1
        echo "Opening App..."
        heroku open
        choice=""
        echo "Do you want to see logs? "
        read choice
        if [ "$choice" = "y" ] 
        then
                echo "Echoing Log..."
                heroku logs --app hrboost
        else
                echo "Bye..."
        fi
fi


