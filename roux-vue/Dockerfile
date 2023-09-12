FROM node:18.17.1-bullseye

RUN mkdir -p /roux-vue
WORKDIR /roux-vue

COPY package.json /roux-vue
RUN npm install
EXPOSE 5173
CMD npm run dev
