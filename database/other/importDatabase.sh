dbUsername=root
dbPassword=I98b7z5$

for entry in ../docker-entrypoint-initdb.d/*.sql; do
    fullFilename="${entry%.*}"
    find="../docker-entrypoint-initdb.d/"
    replace=""
    filename="${fullFilename/$find/$replace}"
    echo $filename

    if [[ ! "$filename" =~ ^(init|updates_final)$ ]]; then
        Result=`mysql -u $dbUsername -p$dbPassword --skip-column-names -e "show databases like '$filename'"`
        if [ ! "$Result" == "$filename" ]; then
            echo $filename
            mysql -u $dbUsername -p$dbPassword < $fullFilename.sql
        fi
    fi
done