# config valid only for current version of Capistrano
lock '3.8.0'

#set :application, 'prerender'

# Default branch is :master
# ask :branch, `git rev-parse --abbrev-ref HEAD`.chomp

# Default value for :scm is :git
# set :scm, :git

# Default value for :format is :pretty
# set :format, :pretty

# Default value for :log_level is :debug
# set :log_level, :debug

# Default value for :pty is false
# set :pty, true

# Default value for :linked_files is []
# set :linked_files, fetch(:linked_files, []).push('config/database.yml', 'config/secrets.yml')

# Default value for linked_dirs is []
# set :linked_dirs, fetch(:linked_dirs, []).push('src/main/resources/static/legacy/node_modules', 'src/main/resources/static/new/node_modules')

# Default value for default_env is {}
# set :default_env, { path: "/opt/ruby/bin:$PATH" }

# Default value for keep_releases is 5
# set :keep_releases, 5
SSHKit.config.command_map[:npm] = "/usr/bin/npm"
SSHKit.config.command_map[:brunch] = "/usr/bin/brunch"
SSHKit.config.command_map[:bower] = "/usr/bin/bower"
SSHKit.config.command_map[:curl] = "/usr/bin/curl"
SSHKit.config.command_map[:gradle] = "./gradlew"
SSHKit.config.command_map[:unzip] = "/usr/bin/unzip"
SSHKit.config.command_map[:curl] = "/usr/bin/curl"

set :file, "sylc.war"

namespace :deploy do

  task :clean do
    run_locally do
      execute :gradle, 'clean'
    end
  end

  task :compile do
    run_locally do
      execute :gradle, "build -x test"
    end
  end

  task :upload_war do
    on roles(:web), in: :parallel do
      upload! "./build/libs/#{fetch(:file)}", "#{fetch(:web_app_path)}/app.war"
    end
  end

  # task :unzip_war do
  #   on roles(:web), in: :parallel do
  #     execute :unzip, "-qo #{fetch(:web_app_path)}/#{fetch(:file)} -d #{fetch(:web_app_path)}/webapps/ROOT"
  #   end
  # end

  # task :upload_jsp do
  #   on roles(:web), in: :parallel do
  #     upload! './src/main/webapp/WEB-INF/jsp', "#{fetch(:web_app_path)}/webapps/ROOT/WEB-INF/", recursive: true
  #   end
  # end

  # task :clean_web_root do
  #   on roles(:web), in: :parallel do
  #     execute :rm, "-rf #{fetch(:web_app_path)}/webapps/ROOT/*"
  #     execute "sudo", "rm -rf #{fetch(:web_app_path)}/work/Catalina/localhost/ROOT"
  #   end
  # end

  task :stop do
    on roles(:web), in: :parallel do
      execute "sudo service sylc stop"
    end
  end

  task :start do
    on roles(:web), in: :parallel do
      execute "sudo service sylc start"
    end
  end

  task :restart do
    on roles(:web), in: :parallel do
      execute "sudo service sylc restart"
    end
  end

  task :java do
    invoke 'deploy:ready'
    invoke 'deploy:restart'
  end

  task :ready do
    invoke 'deploy:clean'
    invoke 'deploy:compile'
    invoke 'deploy:upload_war'
  end

  before 'deploy:starting', 'deploy:clean'

end
