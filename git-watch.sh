fswatch -0 -e '\.git' . | while read -d "" event
do
  git add ${event} && git commit -m `date +%s`
done

