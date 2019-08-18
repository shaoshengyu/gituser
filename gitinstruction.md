<h1>常用的一些git指令</h1>
mkdir <filename>    ——创建一个文件夹(空目录)   假设filename为learngit<br />
cd                  ——进入某文件夹目录<br />
ls                    ——查看所在目录的所有文件<br />
cat readme.txt        ——查看文件内容<br />
vi readme.txt      ——进入文件编辑界面<br />
            1、按i进入编辑模式，此时界面右下角显示insert<br />
            2、编辑完按esc推出insert模式<br />
            3、按shift + ：（shift + 冒号键）输入wq。  ps：wq表示保存并退出，只有q表示只退出<br />
            4、最后按enter键退出界面<br />
rm readme.txt       ——删除文件<br />
pwd                 ——用于显示当前目录<br />

初始化仓库
git  init                      ——初始化一个Git仓库

添加文件到Git仓库：
    1、git add <file>    ——添加文件，可以反复使用多次
            先将文件提交到暂存区
    2、git commit -m <message>    ——提交文件到Git仓库，-m后面输入的是本次提交的说明
            将暂存区文件一次性commit到master上
git status        ——查看仓库当前的状态，随时掌握工作区的状态

git diff          ——查看difference，若git status提示文件被修改过，使用该命令查看修改内容



版本回退
    git log           ——查看从最近到最远的提交日志，若嫌输出的信息太多可以加上 --pretty=oneline参数
  
       git reset --hard HEAD^    ——退回到上一个版本，HEAD表示当前版本
              git reset命令既可以回退版本，也可以把暂存区的修改回退到工作区。当我们用HEAD时，表示最新的版本。

       git reset --hard 7be436d    ——回到退回前的版本(前提是命令行窗口未被关闭，找到上面的对应版本的
                                       版本号)版本号没必要写全，前几位就可以了
            git reflog                                —— 查看命令历史
                                                           （可用于版本退回后想要回到退回前，但已关闭命令行窗口）

管理修改 
          第一次修改 -> git add -> 第二次修改 -> git add -> git commit        【正确，推荐】
          
          第一次修改 -> git add ->  第二次修改 -> git commit     【错误】  
                                                      第二次修改没有被提交，只有再进行一次add、commit

撤销修改 git checkout    
  —git checkout其实是用版本库里的版本替换工作区的版本，无论工作区是修改还是删除，都可“一键还原”。
            使用git status查看仓库当前状态，若有修改 :
          
            一、git checkout -- <file> 放弃工作区的修改（两种情况）:
                            ----此命令让文件回到最近一次git commit或者git add时的状态
                    1、file自修改后还没有被放到暂存区，此时撤销修改回到和版本库一摸一样的状态。
                               直接使用此命令
                    2、file已经添加至暂存区，又做了修改，此时撤销就回到添加至暂存区后的状态。
                                使用git add后，查询仓库状态:
                                    
                              首先使用 git reset HEAD readme.txt，将暂存区的修改退回工作区。
                              再使用 git checkout -- readme.txt  丢弃工作区的修改
                     
            二、已经提交了不合适的修改到版本库时，想要撤销本次提交。
                     参考版本回退进行操作，不过前提是没有推送到远程库

删除文件 rm file
            一般情况，直接在文件管理器中删除，或者用 rm test.txt 删除文件 ，此时git知道你删除文件，和版本库不一致   ，git status会提示你那些文件删除了。
            
            此时有两个选择:
                 1、确实要从版本库删除该文件，则用git rm删掉，并且git commit
                 2、删错了，将误删的文件恢复到最新版本：   git checkout -- test.txt
				 
创建分支并切换 git checkout -b dev
        相当于 git branch dev   之后再 git checkout dev
	    
		查看当前分支  git branch
		日常工作git add file和git commit -m ""
		dev工作完成则切换回master分支 git checkout master
		dev合并到当前分支 git merge dev
		合并完成后删除 git branch -d dev
		
分支合并冲突，把合并失败的文件手动修改再提交。

分支管理策略，平时不在master分支干活，master只用于发布
         
		 2人以下在dev分支工作，2人以上在dev分支的基础上再建立feature分支上工作
         普通模式合并有历史分支  在分支上git add file和git commit -m ""，转回上一分支 git merge --no--ff -m "" dev(或者feature)

bug分支   
          突然遇到要修改的bug，将当前dev分支的工作储藏  git stash		
          然后转到要修复的分支  git checkout bug分支
		  在bug分支创建临时修改分支  git checkout -b issue-101
		  完成修复并git add file， git commit -m "fix bug 101"(假设这步版本号为为4c80512)
		  再切换到bug分支合并 git checkout bug分支    git merge --no--ff -m "" issue-101
          bug修复返回dev分支工作  git checkout dev	  
          查看储藏的工作现场   git stash list
		  恢复现场有2种
		       1 恢复的同时删除stash  git stash pop
			   2 恢复时不删除stash  git stash apply  之后想删除可以  git stash drop
          可以多次stash，恢复时根据工作现场的版本号(假设为stash@{0})恢复   git stash apply stash@{0}	
          bug修复的分支的相关分支通常也有相同bug，切换到那些分支执行之前的修复操作 git cherry-pick 4c805e2

Feature分支 feature-v分支修改完毕但未合并，突然需求变化不再需要，  git branch -D feature-v	

查看远程仓库信息  git remote 
查看具体信息      git remote -v
推送分支          git push master/dev/feature

将本地未push的分叉整理成直线  git rebase 