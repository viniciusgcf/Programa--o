IP="$file"
COUNT=1

while true
do
file="IP"
    while read -r line; 
    do 
        if ping -c $COUNT $line > /dev/null 2>&1; then
           saida="IP = "$line" ok"
        else
           saida="IP = "$line" not_ok"
        fi
        echo $saida
        sleep 2
    done <$file
done
